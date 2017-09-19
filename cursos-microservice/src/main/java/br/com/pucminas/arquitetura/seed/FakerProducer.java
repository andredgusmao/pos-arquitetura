package br.com.pucminas.arquitetura.seed;

import javax.enterprise.inject.Produces;

import com.github.javafaker.Faker;

public class FakerProducer {

	@Produces
	public Faker producer() {
		return new Faker();
	}
}
