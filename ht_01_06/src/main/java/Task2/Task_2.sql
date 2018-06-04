/*1) Обьединить две таблицы чтобы показать
сумму дохода по каждому клиенту который есть в первой таблице
Идклиента – доход
Если дохода не было, то ячейку дохода оставить пустой.
*/

SELECT
  "2_people".id,
  sum("2_income".income)
FROM "2_people"
  LEFT JOIN "2_income"
    ON "2_people".id = "2_income".id
GROUP BY "2_people".id;

/*
2) Выбрать по каждому клиенту из первой таблицы последнюю
дату получения дохода.
Клиенты у которых дохода не было не показывать.
 */
SELECT "2_people".id,
MAX ("2_income".data)
FROM "2_people"
LEFT JOIN "2_income"
ON "2_people".id = "2_income".id
GROUP BY "2_people".id;
 /*
 3) Показать клиентов которых нет в первой таблице,
 но по ним есть доходы.
  */
SELECT * FROM "2_income" WHERE id NOT IN (SELECT "2_people".id FROM "2_people");

/*
4) Показать клиентов которые есть в первой таблице а во второй их нет.
 */

SELECT * FROM "2_people" WHERE id NOT IN (SELECT "2_income".id FROM "2_income");