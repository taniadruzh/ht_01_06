/*
1)Выбрать данные в виде
Название службы|ФИО оператора|ФИО клиента|Последняя дата звонка
 */
SELECT name_service, fio_operator, fio_client, date_contact
FROM "4_service","4_operator","4_client", "4_contact"
WHERE "4_contact".id_service="4_service".id AND
      "4_contact".id_operator="4_operator".id AND
      "4_contact".id_client = "4_client".id;

/*
2)Выбрать данные в виде
Название службы|ФИО оператор|Последняя дата звонка
 */

SELECT name_service, fio_operator, MAX (date_contact) AS lastContact
FROM "4_service","4_operator", "4_contact"
WHERE "4_contact".id_service="4_service".id AND
      "4_contact".id_operator="4_operator".id
      GROUP BY name_service, fio_operator;

/*
3)Выбрать данные в виде
Название службы| Последняя дата звонка|Кол-во звонков
 */

SELECT name_service, MAX (date_contact) AS lastContact, COUNT (name_service)
FROM "4_service", "4_contact"
WHERE "4_contact".id_service="4_service".id
      GROUP BY name_service;


/*
4)Выбрать данные в виде
Дата|Кол-во звонков
 */

SELECT  date_contact, COUNT ("4_contact")
FROM "4_contact"
GROUP BY date_contact;

/*
5)Выбрать данные в виде
Дата|Кол-во клиентов
 */

SELECT  date_contact, COUNT (id_client)
FROM  "4_contact"
GROUP BY date_contact;



