package kz.alishev.service

import kz.alishev.feign.DriverClient
import kz.alishev.model.DriverDto
import kz.alishev.model.Team
import kz.alishev.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(
    private val teamRepository: TeamRepository,
    private val driverClient: DriverClient
) {

    fun updateTeam(id: Long, body: Team): Team {
        val team = teamRepository.findById(id).get()
        body.name?.let { team.name = it }
        body.country?.let { team.country = it }
        teamRepository.save(team)
        return team
    }

    fun find(id: Long): DriverDto {
        return driverClient.getDriver(id)
    }

}