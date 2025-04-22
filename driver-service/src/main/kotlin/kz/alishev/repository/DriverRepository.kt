package kz.alishev.repository

import kz.alishev.model.Driver
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DriverRepository: JpaRepository<Driver, Long> {
}