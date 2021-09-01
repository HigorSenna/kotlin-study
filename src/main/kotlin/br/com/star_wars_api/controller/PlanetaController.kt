package br.com.star_wars_api.controller

import br.com.star_wars_api.dto.request.PlanetaRequestDTO
import br.com.star_wars_api.dto.response.PlanetaResponseDTO
import br.com.star_wars_api.service.PlanetaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/planetas")
class PlanetaController(private val planetaService: PlanetaService) {

    @PostMapping
    fun save(@RequestBody planetaRequestDTO: PlanetaRequestDTO):ResponseEntity<PlanetaResponseDTO> {
        val planetaResponse:PlanetaResponseDTO = this.planetaService.save(planetaRequestDTO)
        return ResponseEntity(planetaResponse, HttpStatus.CREATED);
    }

    @GetMapping
    fun getAll(@RequestParam("start", required = false, defaultValue = "0") start: Int,
               @RequestParam("size", required = false, defaultValue = "10") size: Int): ResponseEntity<List<PlanetaResponseDTO>> {

        val planetasResponse:List<PlanetaResponseDTO> = this.planetaService.findAll(start, size)
        return ResponseEntity.ok(planetasResponse);
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long,
               @RequestBody planetaRequestDTO: PlanetaRequestDTO): ResponseEntity<PlanetaResponseDTO> {

        val planetaResponse:PlanetaResponseDTO = this.planetaService.update(id, planetaRequestDTO)

        return ResponseEntity.ok(planetaResponse);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Long): ResponseEntity<String> {
        this.planetaService.remove(id)
        return ResponseEntity.ok().build();
    }
}