<%-- 
    Document   : Produit
    Created on : 15 mai 2020, 20:12:00
    Author     : a
--%>
<%@page import="back.bean.Panier"%>
<%@page import="back.service.PanierService"%>
<%@page import="back.service.ProduitPanierService"%>
<%@page import="back.service.ProduitService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="back.bean.ProduitPanier"%>


<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="back.bean.Produit"%>
<%  session=request.getSession();

    if (request.getParameter("IdProduit") != null) {
   
        Long numId = Long.parseLong(request.getParameter("IdProduit"));
        PanierService panierService = new PanierService();
        Panier panier = (Panier) session.getAttribute("panier");
        panierService.add(numId, panier);
               
        System.out.println(panier);
    }
%>


<html>
    <head>
        <meta charset="utf-8" http-equiv ="refresh">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.6">
        <title>
            Welcome
        </title>


    </head>
    <body>
        
            <form method="post" action="ProduitControler">


                <h4 class="mb-3">Notre Produit</h4>
             

                Voter Panier <%= ((Panier)(session.getAttribute("panier"))).getProduitPaniers().size() %>                          

                <div class="container">
                    <div class="row">
                        <c:forEach items="${produits}" var="pr">
                            <div class="col-md-3">
                                <div class="card" style="width: 18rem;">
                                    <div class="card-body">
                                        <h5 class="card-title">Produit ${pr.id}</h5>
                                        <p class="card-text">
                                            Code Bare :  ${pr.codebare} <br>
                                            Libelle :  ${pr.libelle} <br>
                                            Prix :  ${pr.prix}</p>

                                        <a href="<c:url value ="/view/Produit.jsp" >
                                               <c:param name="IdProduit" value="${pr.id}"/>   
                                           </c:url> "> ajouter au panier </a>


                                    </div>
                                </div>
                            </div>

                        </c:forEach>


                    </div>
                </div>

            </form>
            <br>
            <button class="btn btn-Secondary center"> <a href="/gestiondeVente/view/PanierValidation.jsp" >Valider </a> </button>

        
    </body> 
</html>