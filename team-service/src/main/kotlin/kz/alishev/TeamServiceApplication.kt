package kz.alishev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class TeamServiceApplication

fun main(args: Array<String>) {
    runApplication<TeamServiceApplication>(*args)
}
