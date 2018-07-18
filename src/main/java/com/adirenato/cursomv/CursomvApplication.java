package com.adirenato.cursomv;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adirenato.cursomv.domain.Categoria;
import com.adirenato.cursomv.domain.Cidade;
import com.adirenato.cursomv.domain.Cliente;
import com.adirenato.cursomv.domain.Endereco;
import com.adirenato.cursomv.domain.Estado;
import com.adirenato.cursomv.domain.ItemPedido;
import com.adirenato.cursomv.domain.Pagamento;
import com.adirenato.cursomv.domain.PagamentoComBoleto;
import com.adirenato.cursomv.domain.PagamentoComCartao;
import com.adirenato.cursomv.domain.Pedido;
import com.adirenato.cursomv.domain.Produto;
import com.adirenato.cursomv.domain.enums.EstadoPagamento;
import com.adirenato.cursomv.domain.enums.TipoCliente;
import com.adirenato.cursomv.repositories.CategoriaRepository;
import com.adirenato.cursomv.repositories.CidadeRepository;
import com.adirenato.cursomv.repositories.ClienteRepository;
import com.adirenato.cursomv.repositories.EnderecoRepository;
import com.adirenato.cursomv.repositories.EstadoRepository;
import com.adirenato.cursomv.repositories.ItemPedidoRepository;
import com.adirenato.cursomv.repositories.PagamentoRepository;
import com.adirenato.cursomv.repositories.PedidoRepository;
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
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Masculino");
		Categoria cat4 = new Categoria(null, "Femenino");
		Categoria cat5 = new Categoria(null, "Infantil");
		Categoria cat6 = new Categoria(null, "Esportivo");
		Categoria cat7 = new Categoria(null, "Casual");
		
		
		// produtos
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado e1 = new Estado(null, "São Paulo");
		Estado e2 = new Estado(null, "Minas Gerais");

		Cidade cid1 = new Cidade(null, "São Paulo", e1);
		Cidade cid2 = new Cidade(null, "Campinas", e1);
		Cidade cid3 = new Cidade(null, "Uberlândia", e2);

		e1.getCidades().addAll(Arrays.asList(cid1, cid2));
		e2.getCidades().addAll(Arrays.asList(cid3));

		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cl1 = new Cliente(null, "Maria Silva", "maria.silvia@pucrs.br", "97812340082",
				TipoCliente.PESSOAFISICA);
		cl1.getTelefone().addAll(Arrays.asList("5133200101", "5133200102"));

		Endereco end1 = new Endereco(null, "Rua Flores", "300", "apto 033", "partenor", "91380000", cl1, cid3);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "91380200", cl1, cid1);

		cl1.getEndereco().addAll(Arrays.asList(end1, end2));
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:00"), end1, cl1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), end2, cl1);

		Pagamento pgt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 5);
		ped1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pgt2);

		cl1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 200, 1, 2000);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0, 2, 80);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100, 1, 800);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));
        
        
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2, ip3));		

	}
}
