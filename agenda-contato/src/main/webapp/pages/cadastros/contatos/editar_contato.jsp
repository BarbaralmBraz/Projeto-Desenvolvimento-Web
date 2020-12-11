<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mt" tagdir="/WEB-INF/tags"%>
 <% String idContato =  request.getParameter("idContato");%>
 <script>
 	function mudarAction(){
 		document.formulario.action ="${pageContext.request.contextPath}/contatoControllerServlet?idContato=<%=idContato%>";
 		document.formulario.submit();
 		
 	}
 </script>
 
<mt:admin_template title="Contatos" breadcrumb="Dashboard">

	<jsp:attribute name="content">
		
     	<div class="row">
          <div class="col-lg-12">
          
          
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Editar Contato</h1>
              </div>
             
              <form class="user" action="${pageContext.request.contextPath}/contatoControllerServlet" id="formulario" name="formulario" method="post">
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="nome" 
                    	placeholder="${nome}" required="required" name="nome">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                  	<input type="email" class="form-control form-control-user" id="email" 
                  		placeholder="${email}" required="required" name="email">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" id="telefone" 
                    	placeholder="${telefone}" required="required" name="telefone">
                  </div>
                </div>
                <div align="center">
                    <input type="button" class="btn btn-warning" onClick="mudarAction()" value="Salvar" />
                    
                </div>
              </form>
                
            </div>
          </div>
        </div>
					
	</jsp:attribute>

</mt:admin_template>
