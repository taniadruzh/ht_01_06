/*
1) Показать сумму дохода по клиенту в валюте банка.*/

SELECT id, SUM ((profit)*(exchange_rate)) FROM "3_client"
GROUP BY id;

/*
2) Добавить к запросу отображение кол-ва уникальных дат
когда был доход по клиенту.
*/

SELECT id, SUM ((profit)*(exchange_rate)), COUNT (DISTINCT "3_client".date) AS CountOfUniqueDate
FROM "3_client"
GROUP BY id;

/*
3) По предыдущему запросу  показать только тех клиентов
у которых кол-во дат когда было поступление больше одной.
*/

SELECT id, SUM ((profit)*(exchange_rate)),
        COUNT (DISTINCT "3_client".date)>1 AS CountOfUniqueDate
FROM "3_client"
GROUP BY id;

/*
4) Выбрать записи по клиентам где платеж между 100 и 250.
 */


SELECT id, SUM ((profit)*(exchange_rate)), SUM ((profit)*(exchange_rate))>100 AND SUM ((profit)*(exchange_rate)) <250 AS Profit2
FROM "3_client"
GROUP BY id;