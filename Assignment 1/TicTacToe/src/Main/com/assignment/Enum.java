package com.assignment;

public class Enum {

    public enum Status{
        Success,
        Failed,
        Draw,
        Invalid
    }

    public enum Messages{
        winner {
            public String toString() {
                return "Wins The Game!";
            }
        },
        draw {
            public String toString() {
                return "Draw Game!";
            }
        },
        inProgress {
            public String toString() {
                return "Game still in Progress!";
            }
        },
        invalidGame{
            public String toString() {
                return "Invalid Grid Detected!";
            }
        },
        invalidInput{
            public String toString() {
                return "Error :: Invalid Input Detected (Not X,O,-)!";
            }
        },
        duplicateInput{
            public String toString() {
                return "Error :: Duplicate Input Detected (Input to same box) !";
            }
        }
    }

    public enum setupValue {
        maxInput(9), row3(7), row2(4), row1(1), row(3), column(3);
        private final int value;

        private setupValue(int value) {
            this.value = value;
        }

        public int val() {
            return value;
        }
    }

    public enum playerSetup{
        p1 {
            public String toString() {
                return "X";
            }
        },
        p2 {
            public String toString() {
                return "O";
            }
        },
        noChoice{
            public String toString() { return "-"; }
        }
    }

}
