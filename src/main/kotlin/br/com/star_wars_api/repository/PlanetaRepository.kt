package br.com.star_wars_api.repository

import br.com.star_wars_api.model.Planeta
import org.springframework.data.jpa.repository.JpaRepository

interface PlanetaRepository: JpaRepository<Planeta, Long> {
}