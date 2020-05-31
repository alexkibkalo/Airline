package com.fly.persistence.entity.baggage;

import com.fly.persistence.entity.general.IdEntity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Baggage extends IdEntity {
}
