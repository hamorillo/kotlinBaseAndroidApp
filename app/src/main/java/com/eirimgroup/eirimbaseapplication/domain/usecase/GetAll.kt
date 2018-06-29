package com.eirimgroup.eirimbaseapplication.domain.usecase

import com.eirimgroup.eirimbaseapplication.data.repository.GenericRepository
import com.eirimgroup.eirimbaseapplication.domain.model.DomainError
import org.funktionale.either.Either

class GetAll(private var genericRepository: GenericRepository){

  operator fun invoke():Either<DomainError, String> = genericRepository.getAll()
}