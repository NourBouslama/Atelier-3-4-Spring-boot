package com.nour.produits2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nour.produits2.entities.Categorie;
import com.nour.produits2.entities.Produit;
import com.nour.produits2.repos.ProduitRepository;
import com.nour.produits2.service.ProduitService;


@SpringBootTest
class Produits2ApplicationTests {


@Autowired
private ProduitRepository produitRepository;
@Autowired
private ProduitService produitService; 


@Test
public void testCreateProduit() {
	Produit prod = new Produit();
	prod.setNomProduit("PC ASUS");
	prod.setPrixProduit(1500.123);
	
	produitRepository.save(prod);
}


@Test
public void testFindProduit()
{
	 Produit p = produitRepository.findById(1L).orElse(null);
	 System.out.println(p);
}

@Test
public void testUpdateProduit()
{
	 Produit p = produitRepository.findById(1L).orElse(null);
	 p.setPrixProduit(1000.0);
	 produitRepository.save(p);
}

@Test
public void testDeleteProduit()
{
	 produitRepository.deleteById(1L);;
	 
}

@Test
public void testListerTousProduits()
{
	List<Produit>  prods = produitRepository.findAll();	 
		for (Produit p : prods)
		{
			System.out.println(p);
		}
	
}







@Test
public void testFindByNomProduitContains()
{
	Page<Produit>  prods = produitService.getAllProduitsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	                                 });	
	/*ou bien
	 for (Produit p : prods)
	{
		System.out.println(p);
	} */
}

@Test
public void testFindByNomProduit()
{
List<Produit> prods = produitRepository.findByNomProduit("iphone X");
for (Produit p : prods)
{
System.out.println(p);
}
}

@Test
public void testFindByNomProduitContains1()
{
List<Produit> prods=produitRepository.findByNomProduitContains("iphone X");
for (Produit p : prods)
{
System.out.println(p);
}
}

@Test
public void testfindByNomPrix()
{
List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 1000.0);
for (Produit p : prods)
{
System.out.println(p);
}
}

@Test
public void testfindByCategorie()
{
Categorie cat = new Categorie();
cat.setIdCat(1L);
List<Produit> prods = produitRepository.findByCategorie(cat);
for (Produit p : prods)
{
System.out.println(p);
}
}

@Test
public void findByCategorieIdCat()
{
List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
for (Produit p : prods)
{
System.out.println(p);
}
 }

@Test
public void testfindByOrderByNomProduitAsc()
{
List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
for (Produit p : prods)
{
System.out.println(p);
}
}

@Test
public void testTrierProduitsNomsPrix()
{
List<Produit> prods = produitRepository.trierProduitsNomsPrix();
for (Produit p : prods)
{
System.out.println(p);
}
}




}
