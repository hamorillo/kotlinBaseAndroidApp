package com.eirimgroup.eirimbaseapplication.data.repository

import com.eirimgroup.eirimbaseapplication.domain.model.DomainError
import com.eirimgroup.eirimbaseapplication.domain.model.UnknownDomainError
import org.funktionale.either.Either

class GenericRepository(private val dataSources:List<GenericDataSource>){

  fun getAll():Either<DomainError, String> =
      dataSources.first().getAll();

}