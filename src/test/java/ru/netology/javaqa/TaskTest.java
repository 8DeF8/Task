package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("позвонить");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicMatchesTrue() {
        String[] subtasks = { "Пойти гулять", "Позвонить родителям"};
        Task epic = new Epic(31, subtasks);

        boolean actual = epic.matches("Позвонить");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicMatchesFalse() {
        String[] subtasks = { "Пойти гулять", "Позвонить родителям"};
        Task epic = new Epic(31, subtasks);

        boolean actual = epic.matches("собака");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMathesTrue() {
        Task meeting = new Meeting(
                88,
                "Выпуск фичи",
                "ToDo",
                "в 8.00 в четверг"
        );

        boolean expected = true;
        boolean actual = meeting.matches("фичи");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMathesFalse() {
        Task meeting = new Meeting(
                88,
                "Выпуск фичи",
                "ToDo",
                "в 8.00 в четверг"
        );

        boolean expected = false;
        boolean actual = meeting.matches("четверг");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTaskMathesFalse() {
        Task task = new Task(87);

        boolean expected = false;
        boolean actual = task.matches("обновление");
        Assertions.assertEquals(expected, actual);
    }




}