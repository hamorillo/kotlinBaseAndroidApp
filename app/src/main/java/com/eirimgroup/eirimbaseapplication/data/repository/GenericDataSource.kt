package com.eirimgroup.eirimbaseapplication.data.repository

import com.eirimgroup.eirimbaseapplication.domain.model.DomainError
import org.funktionale.either.Either

interface GenericDataSource{
  fun getAll(): Either<DomainError, String>
}