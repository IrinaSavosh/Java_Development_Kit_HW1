
/**
 Реализовать клиент-серверное приложение на языке Java с помощью наследования JFrame.
 Его начало в коде ниже:
 */

public class App {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);

    }
}

/*
Клиентское приложение должно отправлять сообщения из текстового поля сообщения
в серверное приложение по нажатию кнопки или по нажатию клавиши Enter на поле ввода
 сообщения. В окне клиентского и серверного приложения должна отображаться
история сообщений. К серверу могут подключаться несколько пользователей и
образовывать подобие чата.
Продублировать импровизированный лог (историю) чата в файле;
При запуске клиента чата заполнять поле истории из файла,
если он существует. Обратите внимание, что чаще всего история сообщений
хранится на сервере и заполнение истории чата лучше делать при соединении
        с сервером, а не при открытии окна клиента.

        В интерфейсе сервера находятся кнопки Start (отвечает за включение сервера) и
    Stop (отключает серве), которые находятся внизу окна, а также поле, где отображаются
сообщения написанные пользователем. В интерфейсе клиента есть полле ввода и кнопка Send
для отправки сообщения, а также поле, гнде выводится история чата.



Результат можно увидеть на скриншотах,
которые также можно найти в материалах к уроку
 */