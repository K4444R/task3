package kz.alishev.model

import javax.persistence.*

@Entity
@Table(name = "drivers")
class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column
    var name: String? = null

    @Column
    var age: Int? = null

    @Column
    var nationality: String? = null

    @Column
    var teamId: String? = null

}