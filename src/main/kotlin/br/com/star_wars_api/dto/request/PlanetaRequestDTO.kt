package br.com.star_wars_api.dto.request

import br.com.star_wars_api.model.Planeta

data class PlanetaRequestDTO(var id: Long? = null, val nome: String, val clima: String, val terreno: String) {



    fun toPlaneta() = Planeta(nome = this.nome, clima = this.clima, terreno = this.terreno)

}