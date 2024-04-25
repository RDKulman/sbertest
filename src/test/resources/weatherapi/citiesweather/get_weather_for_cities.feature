@allure.label.owner=GeorgeMikhalevskij
Feature: Получение погоды для городов при помощи https://www.weatherapi.com/

  @normal
  Scenario Outline: Получение погоды для города "<City>"
    Given Пользователь зарегистрирован на www.weatherapi.com и имеет API токен
    When Отправляется Get запрос на получение погоды для города "<City>"
    Then Полученное значение погоды сравнивается с ожидаемым "<ExpectedTemp>"

    Examples:
      | City      | ExpectedTemp  |
      | Rio       | 31.0          |
      | Palermo   | 12.0          |
      | Lisbon    | 22.0          |
      | Berlin    | 9.0           |
      | Helsinki  | 0.0           |