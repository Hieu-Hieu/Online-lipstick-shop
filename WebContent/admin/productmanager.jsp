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
  <!-- CSS Files -->
   <c:set var="root" value="${pageContext.request.contextPath}"/>
   
  <link href="${root}/admin/static/css/material-dashboard.css" rel="stylesheet" />
</head>

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
                      <c:forEach items="${listProduct}" var="p">
                        <tr>
                          <td>
                            ${p.getProductID()}
                          </td>
                          <td>
                         
                            <img src="<c:url value = "${p.getImgFirst() }"/>" alt="" width="30px" height="30px">
                            <img src="https://file1.dangcongsan.vn/DATA/0/2018/10/68___gi%E1%BA%BFng_l%C3%A0ng_qu%E1%BA%A3ng_ph%C3%BA_c%E1%BA%A7u__%E1%BB%A9ng_h%C3%B2a___%E1%BA%A3nh_vi%E1%BA%BFt_m%E1%BA%A1nh-16_51_07_908.jpg" alt="" width="30px" height="30px">
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
                            <a href="#">Xem/Sửa</a>
                          </td>
                        </tr>
                        </c:forEach>
                        
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
                <a href="${pageContext.request.contextPath}/admin/product/add"><button class="border__button--button" >Thêm</button></a>
                <button class="border__button--button">Xóa</button>
                <button class="border__button--button">Chỉnh sửa</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>

</html>