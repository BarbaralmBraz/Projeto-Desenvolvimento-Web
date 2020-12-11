<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" import="br.com.acme.agenda.controller.ContatoControllerServlet"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags" %>

<mt:admin_template title="Contatos" breadcrumb="Dashboard">
	
	<jsp:attribute name="content">
		
		<section class="content">
		
		
	     <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Lista de Contatos</h6>
		     <div style="margin-left: 180px; margin-top: -30px;">
		     	<a class="btn btn-primary" href="${pageContext.request.contextPath}/pages/cadastros/contatos/cadastro_contatos.jsp">Novo</a>
		     </div>
            </div>
            
			  <c:if test="${not empty sucesso}">
	            <div class="alert alert-success" role="alert">${sucesso}</div>
			  </c:if>
			  
			   <c:if test="${not empty contatoExiste}">
	            <div class="alert alert-danger" role="alert">${contatoExiste}</div>
			  </c:if>
			  
			  <c:if test="${not empty status}">
	            <div class="alert alert-danger" role="alert">${status}</div>
			  </c:if>
			  
			  <c:if test="${not empty remover}">
	            <div class="alert alert-danger" role="alert">${remover}</div>
			  </c:if>
            
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Nome</th>
                      <th>E-mail</th>
                      <th>Telefone</th>
                      <th>Status</th>
                      <th>Ativar/Desativar</th>
                      <th>Remover</th>
                      <th>Editar</th>
                    </tr>
                  </thead>
                 
                  <tbody>
                
                    <c:forEach var="c" items="${contatos}">
			            <input type="hidden" value="${c.id}">
                    	<tr>			                  
	                    	<td>
	                    	  <c:out value="${c.nome}"/>	
	                    	</td>
	                    	<td>
	                    	  <c:out value="${c.email}"/>	
	                    	</td>
	                    	<td>
	                    	  <c:out value="${c.telefone}"/>	
	                    	</td>
	                    	<td>
	                    	  <c:out value="${c.ativo ? 'Ativo' : 'Inativo'}"/>	
	                    	</td>
	                    	
	                    	<td>
	                    	   <a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=1" class="btn ${c.ativo ? 'btn-danger' : 'btn-success'}">${c.ativo ? 'Desativar' : 'Ativar'}</a>	                    	  
	                    	</td>
	                    	<td>
	                    	   <a href="${pageContext.request.contextPath}/contatoControllerServlet?id=${c.id}&action=2" class="btn btn-danger">Remover</a>	                    	  
	                    	</td>
	                    	<td>
	                    	   <a href="${pageContext.request.contextPath}/pages/cadastros/contatos/editar_contato.jsp?idContato=${c.id}" onclick="(function(){let id=c.id; })()"  class="btn btn-primary">Editar</a>
	                    	                      	  
	                    	</td>
                    	</tr>
                    	
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
     	
     </section>
					
	</jsp:attribute>
	
</mt:admin_template>
