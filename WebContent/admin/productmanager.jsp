<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.text.DecimalFormat" %>
<%@page import="get.GetProduct" %>    
<%@page import="model.Product" %>


<!DOCTYPE html>
<html lang="en">
<head>
  
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Quản lí sản phẩm
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
  <!-- CSS Files -->
   <c:set var="root" value="${pageContext.request.contextPath}"/>
   
  <link href="${root}/admin/static/css/material-dashboard.css" rel="stylesheet" />
</head>

<%-- <% String update = (request.getAttribute("updateSuccess"));%>
<% String add = (request.getAttribute("addSuccess").toString());%>
<% String delete = (request.getAttribute("deleteSuccess").toString());%>

<script type="text/javascript">

    var update = "<%=update%>";
    var delete1 = "<%=delete%>";
    var add = "<%=add%>";
    alert(delete1);
    if(update!= "null"){
    	if(update=="1"){
    		alert("Cập nhật thành công");
    	}
    	else{
    		alert("Cập nhật Không thành công");
    	}
   	
    	if(add!= "null"){
        	if(add=="1"){
        		alert("Thêm sản phẩm thành công");
        	}
        	else{
        		alert("Cập nhật sản phẩm Không thành công");
        	}
        }
    	if(delete1!= "null"){
        	if(delete1=="1"){
        		alert("Xóa thành công");
        	}
        	else{
        		alert("Xóa sản phẩm Không thành công");
        	}
        
    }
</script> --%>

<body class="">
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="slidebav.jsp"></jsp:include>
  <div class="wrapper ">
    <div class="main-panel">
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0"> Quản lí sản phẩm</h4>
                  <p class="card-category"> </p>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                      <thead class="">
                        <th>
                          ID
                        </th>
                        <th>
                          Hình ảnh
                        </th>
                        <th>
                          Tên
                        </th>
                        <th>
                          Thể loại
                        </th>
                        <th>
                          Giá tiền
                        </th>
                        <th>
                          Số lượng
                        </th>
                        <th>
                          Action
                        </th>
                      </thead>
                      <tbody>
                      <c:choose>
						<c:when test="${!empty EmptyListProduct }">
								<p>Không tìm thấy sản phẩm nào</p>
						</c:when>
					
					<c:when test="${!empty listProduct}">
                      <c:forEach items="${listProduct}" var="p">
 
                        <tr>
                          <td>
                            ${p.getProductID()}
                          </td>
                          <td>
                         
                            <img src="<c:url value = "${p.getImgFirst() }"/>" alt="" width="30px" height="30px">
                            <img src="<c:url value = "${p.getImgLast() }"/>" alt="" width="30px" height="30px">
                          </td>
                          <td>
                            ${p.getName()}
                          </td>
                          <td>
                          	
                            Son thỏi
                          </td>
                          <td>
                            <fmt:formatNumber var="price" type="number " pattern = "###,###,###" value="${p.getPrice()}" />
							${price}<span>VNĐ</span>
                          </td>
                          <td>
                            ${p.getQuantity() }
                          </td>
                          <td>
                            <a href="${pageContext.request.contextPath }/admin/product/update?id=${p.getProductID()}">Sửa/</a>
                            <a onclick="return ConfirmDelete();" href="${pageContext.request.contextPath }/admin/product/delete?id=${p.getProductID()}">Xóa</a>
                          </td>
                        </tr>
                       
                        </c:forEach>
                        </c:when>
                        </c:choose>
					
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6   align-self-md-center">
            <ul class="pagination modal-2">
              
                                <c:choose>
                                	<c:when test="${currentPage > 1}">
                                		<li class="page-item">
                                		 <a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?currentPage=${currentPage - 1}" tabindex="-1">Previous</a>
                                    </li>
                                	</c:when>
                                	<c:otherwise>
                                		<li class="page-item disabled">
                                		 <a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?currentPage=${currentPage - 1}" tabindex="-1">Previous</a>
                                    </li>
                                	</c:otherwise>
                                </c:choose>
                                    	
	                               
                                    <c:if test="${totalPage > 1 }">
                                    	<c:forEach begin="1" end="${totalPage }" var="page">
                                    		<c:choose>
                                    			<c:when test="${currentPage == page }">
                                    				<li class="page-item active">
                                    					<a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?currentPage=${page}">${page }</a>
                                    				</li> 
                                    			</c:when>
                                    			<c:otherwise>
                                    				<li class="page-item">
                                    					<a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?currentPage=${page}">${page }</a>
                                    				</li> 
                                    			</c:otherwise>
                                    		</c:choose>
                                    	</c:forEach>
                                    </c:if>
                                   
                                    <c:choose>
                                    	<c:when test="${currentPage < totalPage }">
                                    		<li class="page-item">
                                    		<a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?currentPage=${currentPage +1}">Next</a>
                                    </li>
                                    	</c:when>
                                    	<c:otherwise>
                                    		<li class="page-item disabled">
                                    		<a class="page-link" href="${pageContext.request.contextPath }/admin/product/list?currentPage=${currentPage +1}">Next</a>
                                    </li>
                                    	</c:otherwise>
                                    </c:choose>
                                    
                                </ul>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6  align-self-sm-end">
              <div class="border__button">
                <a href="${pageContext.request.contextPath}/admin/product/add"><button class="border__button--button">Thêm mới</button></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>

<script>
    function ConfirmDelete()
    {
      var x = confirm("Bạn có muốn xóa sản phẩm này?");
      if (x)
          return true;
      else
        return false;
    }
</script>  

</html>