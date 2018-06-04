package Task1.ServicePeople;

import Task1.DomenObject.People;

import java.util.ArrayList;

public class CreatePeople {
    ArrayList<People> peopleArrayList = new ArrayList<>();

    public CreatePeople() {
        People people = new People("FIO", "Dnepr", "123",11);
        People people1 = new People("FIO1", "Dnepr1", "123",12);
        People people2 = new People("FIO2", "Dnepr2", "123",13);
        People people3 = new People("FIO3", "Dnepr3", "123",14);
        People people4 = new People("FIO4", "Dnepr4", "123",14);
        People people5 = new People("FIO5", "Dnepr5", "123",13);
        People people6 = new People("FIO6", "Dnepr6", "123",12);
        People people7 = new People("FIO7", "Dnepr7", "123",11);
        People people8 = new People("FIO8", "Dnepr8", "123",15);
        People people9 = new People("FIO9", "Dnepr9", "123",21);
        peopleArrayList.add(people);
        peopleArrayList.add(people1);
        peopleArrayList.add(people2);
        peopleArrayList.add(people3);
        peopleArrayList.add(people4);
        peopleArrayList.add(people5);
        peopleArrayList.add(people6);
        peopleArrayList.add(people7);
        peopleArrayList.add(people8);
        peopleArrayList.add(people9);
    }

    public ArrayList<People> getPeopleArrayList() {
        return peopleArrayList;
    }
}
