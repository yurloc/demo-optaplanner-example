# Instructions

Clone the repository and run:

    ./mvnw clean install

Observe the output. Interesting lines:

    ...
    Starting DemoApplication using Java 17.0.1 on ##### with PID ##### (/home/#####/target/classes started by ##### in /home/#####)
    No active profile set, falling back to default profiles: default
        Model annotations parsed for solution VehicleRoutingSolution:
            Entity Standstill:
                Shadow variable nextCustomer (pretty fast access with LambdaMetafactory)
            Entity Customer:
                Genuine variable previousStandstill (pretty fast access with LambdaMetafactory)
                Shadow variable vehicle (pretty fast access with LambdaMetafactory)
            Entity TimeWindowedCustomer:
                Shadow variable arrivalTime (pretty fast access with LambdaMetafactory)
    ...
    Problem score (before solving): -2init/0hard/0soft
    Solution score (after solving): -20hard/-12000soft
