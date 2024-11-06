<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<div id="Catalog">
   <form action="shippingForm">
   <table>
      <tr>
         <th colspan=2>Payment Details</th>
      </tr>
      <tr>
         <td>Card Type:</td>
         <td>
            <label>
               <select name="order.cardType">
                  <c:forEach var="cardType" items="${sessionScope.cardTypes}">
                     <option value="${cardType}">${cardType}</option>
                  </c:forEach>
               </select>
            </label>
         </td>
      </tr>
      <tr>
         <td>Card Number:</td>
         <td>
            <label>
               <input type="number" name="order.creditCard">
               * Use a fake number!
            </label>
         </td>
      </tr>
      <tr>
         <td>Expiry Date (MM/YYYY):</td>
         <td>
            <label>
               <input type="text" name="order.expiryDate">
            </label>
         </td>
      </tr>
      <tr>
         <th colspan=2>Billing Address</th>
      </tr>

      <tr>
         <td>First name:</td>
         <td>
            <label>
               <input type="text" name="order.billToFirstName">
            </label>
         </td>
      </tr>
      <tr>
         <td>Last name:</td>
         <td>
            <label>
               <input type="text" name="order.billToLastName">
            </label>
         </td>
      </tr>
      <tr>
         <td>Address 1:</td>
         <td>
            <label>
               <input type="text" size="40" name="order.billAddress1">
            </label>
         </td>
      </tr>
      <tr>
         <td>Address 2:</td>
         <td>
            <label>
               <input type="text" size="40" name="order.billAddress2">
            </label>
         </td>
      </tr>
      <tr>
         <td>City:</td>
         <td>
            <label>
               <input type="text" name="order.billCity">
            </label>
         </td>
      </tr>
      <tr>
         <td>State:</td>
         <td>
            <label>
               <input type="text" size="4" name="order.billState">
            </label>
         </td>
      </tr>
      <tr>
         <td>Zip:</td>
         <td>
            <label>
               <input type="text" size="10" name="order.billZip">
            </label>
         </td>
      </tr>
      <tr>
         <td>Country:</td>
         <td>
            <label>
               <input type="text" size="15" name="order.billCountry">
            </label>
         </td>
      </tr>

      <tr>
         <td colspan=2>
            <label>
               <input type="checkbox" name="shippingAddressRequired">
            </label>
            Ship to different address...
         </td>
      </tr>

   </table>
      <button class="CatalogButton" type="submit" name="newOrder">Continue</button>
      <button class="CatalogButton" type="reset" name="reset">Reset</button>
   </form>
</div>

<%@ include file="../common/bottom.jsp"%>