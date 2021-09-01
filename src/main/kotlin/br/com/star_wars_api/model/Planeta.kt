package br.com.star_wars_api.model

import br.com.star_wars_api.dto.response.PlanetaResponseDTO
import javax.persistence.*

@Entity
@Table(name = "planetas")
data class Planeta(@Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
                   val nome: String, val clima: String, val terreno: String) {

    fun toPlanetaResponseDTO() = PlanetaResponseDTO(id = this.id, nome = this.nome, clima = this.clima, terreno = this.terreno)

}