import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DaysOfTheYear {
    /**
     This is basic game named Days of the year we have 2 players and the first player to get to the
     31st of december wins the game.
     */

    private static final Scanner IN = new Scanner(System.in);
    private static int currentDate = 1;
    static final int LAST_DAY_OF_MONTH = 31;
    static final int LAST_DAY_OF_MONTH_2 = 30;
    static final int LAST_MONTH_OF_YEAR = 12;
    static final int LAST_DAY_OF_FEB = 28;
    static final int FIRST_DAY_OF_MONTH = 1;
    private static int currentMonth = 1;
    private static int player = 1;
    static final int MONTH_1 = 1;
    static final int MONTH_2 = 2;
    static final int MONTH_3 = 3;
    static final int MONTH_4 = 4;
    static final int MONTH_5 = 5;
    static final int MONTH_6 = 6;
    static final int MONTH_7 = 7;
    static final int MONTH_8 = 8;
    static final int MONTH_9 = 9;
    static final int MONTH_10 = 10;
    static final int MONTH_11 = 11;
    static final int MONTH_12 = 12;

    public static void main(String[] args) {
        // To override the current date and current month with commandline.
        if (args.length > 1) {
            currentDate = Integer.parseInt(args[0]);
            currentMonth = Integer.parseInt(args[1]);
        }
        // To process userInput either day or month and this keeps looping until the current date is
        // 31 and current month is 12 and prints out the winner of the game.
        while (currentDate != LAST_DAY_OF_MONTH || currentMonth != LAST_MONTH_OF_YEAR) {
            System.out.println("The current date is : " + currentDate + dayOfTheMonthSuffix(currentDate) + " of "
                    + getMonth(currentMonth));
            int lastDayOfMonth = 0;
            final int lastMonthOfTheYear = 12;
            // Prints out current player.
            if (player == 1) {
                System.out.println("It's player " + player + "'s turn!");
            } else {
                System.out.println("It's player " + player + "'s turn!");
            }
            String dayOrMonth = "";
            System.out.print("Do you want to increase the day or the month? (day or month):");
            boolean correctChoice = false;
            while (!correctChoice) {
                dayOrMonth = IN.next().toLowerCase(Locale.ROOT);
                if (dayOrMonth.equals("day")) {
                    // To validate if the currentDate is not the last day of currentMonth
                    if (currentDate != lastDayOfMonth) {
                        switch (currentMonth) {
                            case MONTH_1, MONTH_3, MONTH_5, MONTH_7, MONTH_8, MONTH_10, MONTH_12 -> {
                                if (currentDate == LAST_DAY_OF_MONTH) {
                                    lastDayOfMonth = currentDate;
                                    System.out.println("Input invalid, please try again!");
                                } else {
                                    correctChoice = true;
                                }
                            }
                            case MONTH_2 -> {
                                if (currentDate == LAST_DAY_OF_FEB) {
                                    lastDayOfMonth = currentDate;
                                    System.out.println("Input invalid, please try again!");

                                } else {
                                    correctChoice = true;
                                }
                            }
                            case MONTH_6, MONTH_4, MONTH_9, MONTH_11 -> {
                                if (currentDate == LAST_DAY_OF_MONTH_2) {
                                    lastDayOfMonth = currentDate;
                                    System.out.println("Input invalid, please try again!");
                                } else {
                                    correctChoice = true;
                                }
                            }
                            default -> {

                            }
                        }
                    } else {
                        System.out.println("Input invalid, please try again!");
                    }
                } else if (dayOrMonth.equals("month")) {
                    // To validate if the CurrentMonth is not the last Month of the year
                    if (currentMonth != lastMonthOfTheYear) {
                        correctChoice = true;
                    } else {
                        System.out.println("Input invalid, please try again!");
                    }
                } else {
                    System.out.println("Input invalid, please try again!");
                }
            }
            if (dayOrMonth.equals("day")) {
                day();
            }
            if (dayOrMonth.equals("month")) {
                setCurrentMonth();
            }
        }
        System.out.println("The current date is : " + currentDate + dayOfTheMonthSuffix(currentDate) + " of "
                + getMonth(currentMonth));
        // prints the winner of the game.
        if (player == 1) {
            System.out.println("Player 2 is the winner of the game!");
        } else {
            System.out.println("Player 1 is the winner of the game!");
        }
        IN.close();
    }

    // Method to get suffix of the date.
    static String dayOfTheMonthSuffix(int currentDay) {
        final int eleven = 11;
        final int thirteen = 13;
        final int ten = 10;
        final int first = 1;
        final int second = 2;
        final int third = 3;
        if (currentDay >= eleven && currentDay <= thirteen) {
            return "th";
        }
        return switch (currentDay % ten) {
            case first -> "st";
            case second -> "nd";
            case third -> "rd";
            default -> "th";
        };
    }

    // Method to get the month Names.
    private static String getMonth(int num) {
        return switch (num) {
            case MONTH_1 -> "january";
            case MONTH_2 -> "february";
            case MONTH_3 -> "march";
            case MONTH_4 -> "april";
            case MONTH_5 -> "may";
            case MONTH_6 -> "june";
            case MONTH_7 -> "july";
            case MONTH_8 -> "august";
            case MONTH_9 -> "september";
            case MONTH_10 -> "october";
            case MONTH_11 -> "november";
            case MONTH_12 -> "december";
            default -> null;
        };
    }

    //To validate the user date input and update the current date.
    static void day() {
        boolean correctInput = false;
        while (!correctInput) {
            System.out.print("Which day do you want to pick: ");
            try {
                int day = IN.nextInt();
                // To check if date is valid.
                if (currentMonth >= MONTH_1 && currentMonth <= MONTH_12) {
                    switch (currentMonth) {
                        case MONTH_2 -> {
                            if (day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_FEB) {
                                if (day > currentDate) {
                                    correctInput = true;
                                    currentDate = day;
                                    if (player == 2) {
                                        player = 1;
                                    } else {
                                        player = 2;
                                    }
                                } else {
                                    System.out.println("Input invalid, please try again!");
                                }
                            } else {
                                System.out.println("Input invalid, please try again!");
                            }
                        }
                        case MONTH_1, MONTH_3, MONTH_5, MONTH_7, MONTH_8, MONTH_10, MONTH_12 -> {
                            if (day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_MONTH) {
                                if (day > currentDate) {
                                    correctInput = true;
                                    currentDate = day;
                                    if (player == 2) {
                                        player = 1;
                                    } else {
                                        player = 2;
                                    }
                                } else {
                                    System.out.println("Input invalid, please try again!");
                                }
                            } else {
                                System.out.println("Input invalid, please try again!");
                            }
                        }
                        case MONTH_6, MONTH_4, MONTH_9, MONTH_11 -> {
                            if (day >= FIRST_DAY_OF_MONTH && day <= LAST_DAY_OF_MONTH_2) {
                                if (day > currentDate) {
                                    correctInput = true;
                                    currentDate = day;
                                    if (player == 2) {
                                        player = 1;
                                    } else {
                                        player = 2;
                                    }
                                } else {
                                    System.out.println("Input invalid, please try again!");
                                }
                            } else {
                                System.out.println("Input invalid, please try again!");
                            }
                        }
                        default -> {
                        }
                    }
                } else {
                    System.out.println("Input invalid, please try again!");
                }
                // Catch invalid input and print error message.
            } catch (InputMismatchException e) {
                System.out.println("Input invalid, please try again!");
                IN.nextLine();
            }
        }
    }

    //To validate the user month input and update current month.
    static void setCurrentMonth() {
        boolean correctMonth = false;
        int month;
        do {
            System.out.print("Which month do you want to pick: ");
            try {
                month = IN.nextInt();
                // check if currentDate matches with the currentMonth.
                if (month >= MONTH_1 && month <= MONTH_12) {
                    switch (month) {
                        case MONTH_2 -> {
                            if (currentDate >= FIRST_DAY_OF_MONTH && currentDate <= LAST_DAY_OF_FEB) {
                                if (month > currentMonth) {
                                    correctMonth = true;
                                    currentMonth = month;
                                    if (player == 2) {
                                        player = 1;
                                    } else {
                                        player = 2;
                                    }
                                } else {
                                    System.out.println("Input invalid, please try again!");
                                }
                            } else {
                                System.out.println("Input invalid, please try again!");
                            }
                        }
                        case MONTH_1, MONTH_3, MONTH_5, MONTH_7, MONTH_8, MONTH_10, MONTH_12 -> {
                            if (currentDate >= FIRST_DAY_OF_MONTH && currentDate <= LAST_DAY_OF_MONTH) {
                                if (month > currentMonth) {
                                    correctMonth = true;
                                    currentMonth = month;
                                    if (player == 2) {
                                        player = 1;
                                    } else {
                                        player = 2;
                                    }
                                } else {
                                    System.out.println("Input invalid, please try again!");
                                }
                            } else {
                                System.out.println("Input invalid, please try again!");
                            }
                        }
                        case MONTH_6, MONTH_4, MONTH_9, MONTH_11 -> {
                            if (currentDate >= FIRST_DAY_OF_MONTH && currentDate <= LAST_DAY_OF_MONTH_2) {
                                if (month > currentMonth) {
                                    correctMonth = true;
                                    currentMonth = month;
                                    if (player == 2) {
                                        player = 1;
                                    } else {
                                        player = 2;
                                    }
                                } else {
                                    System.out.println("Input invalid, please try again!");
                                }
                            } else {
                                System.out.println("Input invalid, please try again!");
                            }
                        }
                        default -> {
                        }
                    }
                } else {
                    System.out.println("Input invalid, please try again!");
                }
                // Catch invalid input and print error message.
            } catch (InputMismatchException e) {
                System.out.println("Input invalid, Try Again!");
                IN.nextLine();
            }
        } while (!correctMonth);
    }
}
