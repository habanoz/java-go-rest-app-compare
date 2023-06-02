## Java and Go Rest Applications For Performance Comparison

5 rest applications are used in the test bench:
1. Go
2. java micronaut
3. java spring
4. java micronaout native
5. java spring native

### Container Stats

| App              | Image Size(MB) | Startup Times(ms) | Initial Memory Consumption(MB) |
|------------------|----------------|-------------------|--------------------------------|
| go               | 14             | -                 | 4.5                            |
| micronaut        | 340            | 638               | 79.3                           |
| spring           | 345            | 1349              | 118                            |
| micronaut-native | 81             | 74                | 10                             |
| spring-native    | 99             | 31                | 28.4                           |

### K6 Test Results

| App              | Executions | Interrupted | Avg(ms) | Min(ms) | Med(ms) | Max(ms) | p(90) (ms) | p(95) (ms) |
|------------------|------------|-------------|---------|---------|---------|---------|------------|------------|
| go               | 368416     | 0           | 798     | 240     | 746     | 2180    | 1180       | 1300       |
| micronaut        | 119519     | 0           | 2530    | 812     | 2450    | 5620    | 3430       | 3910       |
| spring           | 263404     | 1808        | 917     | 288     | 663     | 9400    | 1680       | 1890       |
| micronaut-native | 119004     | 0           | 2580    | 700     | 2550    | 4900    | 3380       | 3610       |
| spring-native    | 333064     | 1808        | 728     | 231     | 647     | 8310    | 979        | 1210       |
