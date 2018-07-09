package com.adirenato.cursomv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adirenato.cursomv.domain.Categoria;
import com.adirenato.cursomv.domain.Cidade;
import com.adirenato.cursomv.domain.Estado;
import com.adirenato.cursomv.domain.Produto;
import com.adirenato.cursomv.repositories.CategoriaRepository;
import com.adirenato.cursomv.repositories.CidadeRepository;
import com.adirenato.cursomv.repositories.EstadoRepository;
import com.adirenato.cursomv.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomvApplication implements CommandLineRunner {
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	CidadeRepository cidadeRepository;
	@Autowired 
	EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		// produtos
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado e1 = new Estado(null, "São Paulo");
		Estado e2 = new Estado(null, "Minas Gerais");
		
		Cidade cid1 = new Cidade(null, "São Paulo", e1);
		Cidade cid2 = new Cidade(null, "Campinas", e1);
		Cidade cid3 = new Cidade(null, "Uberlândia", e2);
		
		e1.getCidades().addAll(Arrays.asList(cid1,cid2));
		e2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3));
	}
}
