<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<div id="Catalog">
   <form action="commitOrder">
      <div id="billAddress">
         <table>
            <tr>
               <th colspan=2>Payment Details</th>
            </tr>
            <tr>
               <td>Card Type:</td>
               <td>
                  <label>
                     <select name="order.cardType" id="order.cardType">
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
                     <input type="number" name="order.creditCard" id="order.creditCard">
                     * Use a fake number!
                  </label>
               </td>
            </tr>
            <tr>
               <td>Expiry Date (MM/YYYY):</td>
               <td>
                  <label>
                     <input type="text" name="order.expiryDate" id="order.expiryDate">
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
                     <input type="text" name="order.billToFirstName" id="order.billToFirstName" value="${sessionScope.order.billToFirstName}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>Last name:</td>
               <td>
                  <label>
                     <input type="text" name="order.billToLastName" id="order.billToLastName" value="${sessionScope.order.billToLastName}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>Address 1:</td>
               <td>
                  <label>
                     <input type="text" size="40" name="order.billAddress1" id="order.billAddress1" value="${sessionScope.order.billAddress1}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>Address 2:</td>
               <td>
                  <label>
                     <input type="text" size="40" name="order.billAddress2" id="order.billAddress2" value="${sessionScope.order.billAddress2}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>City:</td>
               <td>
                  <label>
                     <input type="text" name="order.billCity" id="order.billCity" value="${sessionScope.order.billCity}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>State:</td>
               <td>
                  <label>
                     <input type="text" size="4" name="order.billState" id="order.billState" value="${sessionScope.order.billState}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>Zip:</td>
               <td>
                  <label>
                     <input type="text" size="10" name="order.billZip" id="order.billZip" value="${sessionScope.order.billZip}">
                  </label>
               </td>
            </tr>
            <tr>
               <td>Country:</td>
               <td>
                  <label>
                     <input type="text" size="15" name="order.billCountry" id="order.billCountry" value="${sessionScope.order.billCountry}">
                  </label>
               </td>
            </tr>

            <tr>
               <td colspan=2>
                  <label>
                     <input type="checkbox" name="shippingAddressRequired" id="shippingAddressRequired">
                  </label>
                  Ship to different address...
               </td>
            </tr>

         </table>
            <button class="CatalogButton" type="button" id="continue" onmousedown="continueBtnClicked()" name="newOrder">Continue</button>
            <button class="CatalogButton" type="reset" name="reset">Reset</button>
      </div>
      <div id="shipAddress" style="display: none">
         <table>
            <tr>
               <th colspan=2>Shipping Address</th>
            </tr>

            <tr>
               <td>First name:</td>
               <td>
                  <label><input type="text" name="order.shipToFirstName" value="${sessionScope.order.shipToFirstName}"></label>
               </td>
            </tr>
            <tr>
               <td>Last name:</td>
               <td>
                  <label><input type="text" name="order.shipToLastName" value="${sessionScope.order.shipToLastName}"></label>
               </td>
            </tr>
            <tr>
               <td>Address 1:</td>
               <td>
                  <label><input type="text" name="order.shipAddress1" value="${sessionScope.order.shipAddress1}"></label>
               </td>
            </tr>
            <tr>
               <td>Address 2:</td>
               <td>
                  <label><input type="text" name="order.shipAddress2" value="${sessionScope.order.shipAddress2}"></label>
               </td>
            </tr>
            <tr>
               <td>City:</td>
               <td>
                  <label><input type="text" name="order.shipCity" value="${sessionScope.order.shipCity}"></label>
               </td>
            </tr>
            <tr>
               <td>State:</td>
               <td>
                  <label><input type="text" size="4" name="order.shipState" value="${sessionScope.order.shipState}"></label>
               </td>
            </tr>
            <tr>
               <td>Zip:</td>
               <td>
                  <label><input type="text" size="10" name="order.shipZip" value="${sessionScope.order.shipZip}"></label>
               </td>
            </tr>
            <tr>
               <td>Country:</td>
               <td>
                  <label><input type="text" size="15" name="order.shipCountry" value="${sessionScope.order.shipCountry}"></label>
               </td>
            </tr>

         </table>

         <input type="submit" name="newOrder" value="Continue">
      </div>
   </form>
</div>

<script src="js/order.js"></script>
<%@ include file="../common/bottom.jsp"%>