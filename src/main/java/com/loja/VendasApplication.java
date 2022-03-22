package com.loja;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.loja.domain.Categoria;
import com.loja.domain.Cidade;
import com.loja.domain.Cliente;
import com.loja.domain.Endereco;
import com.loja.domain.Estado;
import com.loja.domain.ItemPedido;
import com.loja.domain.Pagamento;
import com.loja.domain.PagamentoBoleto;
import com.loja.domain.PagamentoComCartao;
import com.loja.domain.Pedido;
import com.loja.domain.Produto;
import com.loja.domain.enums.EstadoPagamento;
import com.loja.domain.enums.TipoCliente;
import com.loja.repositories.CategoriaRepositorio;
import com.loja.repositories.CidadeRepositorio;
import com.loja.repositories.ClienteRepositorio;
import com.loja.repositories.EnderecoRepositorio;
import com.loja.repositories.EstadoRepositorio;
import com.loja.repositories.ItemPedidoRepositorio;
import com.loja.repositories.PagamentoRepositorio;
import com.loja.repositories.PedidoRepositorio;
import com.loja.repositories.ProdutoRepositorio;

@SpringBootApplication
public class VendasApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepositorio cR;

	@Autowired
	private ProdutoRepositorio pR;

	@Autowired
	private EstadoRepositorio eR;

	@Autowired
	private CidadeRepositorio ciR;
	
	@Autowired
	private EnderecoRepositorio endR;
	
	@Autowired
	private ClienteRepositorio cliR;
	
	@Autowired
	private PedidoRepositorio pedR;
	
	@Autowired
	private PagamentoRepositorio pagR;
	
	@Autowired
	private ItemPedidoRepositorio ipR;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 60.00);

		
		  cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		  cat2.getProdutos().addAll(Arrays.asList(p2));
		  
		  p1.getCategorias().addAll(Arrays.asList(cat1));
		  p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		  p3.getCategorias().addAll(Arrays.asList(cat1));
		 

		cR.saveAll(Arrays.asList(cat1, cat2));
		pR.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		/*
		 * ja esta sendo instanciado na cidade
		 * 
		 * est1.getCidades().addAll(Arrays.asList(c1));
		 * est2.getCidades().addAll(Arrays.asList(c2, c3));
		 */
		eR.saveAll(Arrays.asList(est1, est2));
		ciR.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Marcone Silva", "marcone@gmail.com", "1234567804", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("12345678", "87654321"));
		
		Endereco e1 = new Endereco(null, "Rua carlito teves", "490", null, "tatuape", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua barao", "490", null, "tatuape", "38220834", cli1, c2);
		
		/*
		 * ja esta sendo instanciado no endereço
		 * 
		 * cli1.getEnderecos().addAll(e1, e2);
		 */
		
		cliR.saveAll(Arrays.asList(cli1));
		endR.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("21/03/2022 17:37"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("20/03/2022 16:37"), cli1, e2);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("27/03/2022 00:00"), null);
		ped2.setPagamento(pag2);
		
		/*
		 * ja esta sendo instanciado no pagamento
		 *  
		 *  cli1.getPedidos().addAll(Arrays.asList(ped1, ped2)); */
		
		pedR.saveAll(Arrays.asList(ped1, ped2));
		pagR.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		/*
		 * ja esta sendo instanciado no ItemPedido
		 * 
		 * ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		 * ped2.getItens().addAll(Arrays.asList(ip3));
		 * 
		 * p1.getItens().addAll(Arrays.asList(ip1));
		 * p2.getItens().addAll(Arrays.asList(ip3));
		 * p3.getItens().addAll(Arrays.asList(ip2));
		 */
		
		
		ipR.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
