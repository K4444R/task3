package kz.alishev.controller

import kz.alishev.model.Driver
import kz.alishev.repository.DriverRepository
import kz.alishev.service.DriverService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/drivers")
class DriverController(
    private val driverService: DriverService,
    private val driverRepository: DriverRepository
) {

    @GetMapping
    fun getDrivers(): List<Driver> {
        return driverRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getDriver(@PathVariable id: Long): Driver {
        return driverRepository.findById(id).get()
    }

    @PostMapping
    fun createDriver(@RequestBody driver: Driver): Driver {
        return driverRepository.save(driver)
    }

    @PutMapping("/{id}")
    fun updateDriver(@PathVariable id: Long, @RequestBody body: Driver): Driver {
        return driverService.updateDriver(id, body)
    }

}