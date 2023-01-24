package com.example.algo_0.f1;

public class DirectoryEntry_2023 {

    public String name;
    public String number;

    public DirectoryEntry_2023(String name, String number){
        this.name=name;
        this.number=number;
    }

    @Override
    public boolean equals(Object o){
         return (o instanceof DirectoryEntry_2023) &&
               name.equals(((DirectoryEntry_2023) o).name);
    }
}
