package br.com.star_wars_api.service

import br.com.star_wars_api.dto.request.PlanetaRequestDTO
import br.com.star_wars_api.dto.response.PlanetaResponseDTO
import br.com.star_wars_api.repository.PlanetaRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PlanetaService(private val planetaRepository: PlanetaRepository) {

    fun save(planetaRequest: PlanetaRequestDTO)
        = this.planetaRepository.save(planetaRequest.toPlaneta()).toPlanetaResponseDTO()

    fun findAll(start: Int, size: Int):List<PlanetaResponseDTO> {
        val pageable: Pageable = PageRequest.of(start, size)
        return this.planetaRepository.findAll(pageable).map { it.toPlanetaResponseDTO() }.toList()
    }

    fun remove(planetId: Long) {
        this.planetaRepository.findById(planetId).ifPresent { this.planetaRepository.deleteById(planetId) }
    }

    fun update(id: Long, planetaRequest: PlanetaRequestDTO): PlanetaResponseDTO {
        planetaRequest.id = id
        return this.save(planetaRequest)
    }
}