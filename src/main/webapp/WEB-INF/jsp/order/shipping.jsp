<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/top.jsp"%>

<div id="Catalog"><form action="commitOrder">
    <table>
        <tr>
            <th colspan=2>Shipping Address</th>
        </tr>

        <tr>
            <td>First name:</td>
            <td>
                <label><input type="text" name="order.shipToFirstName"></label>
            </td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td>
                <label><input type="text" name="order.shipToLastName"></label>
            </td>
        </tr>
        <tr>
            <td>Address 1:</td>
            <td>
                <label><input type="text" name="order.shipAddress1"></label>
            </td>
        </tr>
        <tr>
            <td>Address 2:</td>
            <td>
                <label><input type="text" name="order.shipAddress2"></label>
            </td>
        </tr>
        <tr>
            <td>City:</td>
            <td>
                <label><input type="text" name="order.shipCity"></label>
            </td>
        </tr>
        <tr>
            <td>State:</td>
            <td>
                <label><input type="text" size="4" name="order.shipState"></label>
            </td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td>
                <label><input type="text" size="10" name="order.shipZip" /></label>
            </td>
        </tr>
        <tr>
            <td>Country:</td>
            <td>
                <label><input type="text" size="15" name="order.shipCountry"></label>
            </td>
        </tr>

    </table>

    <input type="submit" name="newOrder" value="Continue">

</form></div>

<%@ include file="../common/bottom.jsp"%>