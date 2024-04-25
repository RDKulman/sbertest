@allure.label.owner=GeorgeMikhalevskij
Feature: При тех или иных некорректных входных данных текст ошибки в ответе на запрос соотвествует документации

  @minor
  Scenario Outline: Получение текста ошибки при некорректных входных данных
    Given Пользователь предоставляет API токен "<Token>" к ресурсу www.weatherapi.com
    When Выполняется Get запрос на URL "<URL>" для получения погоды города "<City>"
    Then Полученный текст ошибки сравнивается с ожидаемым текстом "<ErrorDescription>"

    Examples:
      | Token                               | URL             | City    | ErrorDescription              |
      | 735dd42baa5247ae850121438242104     | /currentm.json  | Moscow  | API URL is invalid.           |
      | 735dd42baa5247ae850121438242104     | /current.json   |         | Parameter 'q' not provided.   |
      |                                     | /current.json   | Moscow  | API key not provided.         |
      | 735dd42baa5247ae850121438242104flb  | /current.json   | Moscow  | API key has been disabled.    |
