package com.eirimgroup.eirimbaseapplication.domain.model

sealed class DomainError
class UnknownDomainError:DomainError()