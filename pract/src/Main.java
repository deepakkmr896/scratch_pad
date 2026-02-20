import design_pattern.abstract_factory.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ComputeMachine customComputer_1 = new ComputeMachine
                .ComputeMachineBuilder()
                .monitor(new LargeMonitor().create())
                .button(new QuertyButton().create())
                .build();

        ComputeMachine customComputer_2 = new ComputeMachine
                .ComputeMachineBuilder()
                .monitor(new SmallMonitor().create())
                .button(new TraditionalButton().create())
                .build();

        System.out.println(customComputer_1);
        System.out.println(customComputer_2);
    }
}

//class Animal {
//    public Animal totalLegs() {
//        return this;
//    }
//}
//
//class Bird extends Animal {
//    @Override
//    public Bird totalLegs() {
//        return (Bird) super.totalLegs();
//    }
//}