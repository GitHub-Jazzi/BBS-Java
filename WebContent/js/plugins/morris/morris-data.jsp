<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

$(function() {

 
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "帖子数",
            value: <c:out value="${ sessionScope.noteNum}" />
        }, {
            label: "会员数量",
            value: <c:out value="${ sessionScope.userNum}" />
        }, {
            label: "模块专区数量",
            value: <c:out value="${ sessionScope.moduleNum}" />
        }],
        resize: true
    });

    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '早上',
            a: <c:out value="${ sessionScope.counter.morning}" />
        }, {
            y: '中午',
            a: <c:out value="${ sessionScope.counter.noon}" />
        }, {
            y: '下午',
            a: <c:out value="${ sessionScope.counter.evening}" />
        },{
            y: '夜晚',
            a: <c:out value="${ sessionScope.counter.night}" />
        }],
        xkey: 'y',
        ykeys: ['a'],
        labels: ['浏览量'],
        hideHover: 'auto',
        resize: true
    });
});

