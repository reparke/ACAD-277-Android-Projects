package acad277;

import java.util.Scanner;

public class Main {

    public static final int VOTING_AGE = 18;

    public static void main(String[] args) {
        String name = "";
        int age = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("What is your first name? ");
        name = input.next();
        System.out.println("How old are you? ");
        age = input.nextInt();

        if (age >= VOTING_AGE) {
            System.out.println("You can vote");
        }
        else {
            System.out.println("You can not vote");
        }


    }
}

/*
#Basic While Loops
counter = 0
while counter < 3:
    print(counter)
    counter += 1

# Count-controlled While
total = 0
counter = 0
while counter < 10:
    total += counter
    counter += 5
print(total)


# Sentry-controlled While
num = int(input("enter a number (enter -1 to stop): "))
while num != -1:
    print(num)
    num = int(input("enter a number (enter -1 to stop): "))

# Summing
num = int(input("Enter a positive number: "))
total = 0
counter = 0
while counter <= num:
    total += counter
    counter += 1
print(total)


# sum with odd/even - version 1
# SKIP - I (Rob) like this version but students tend to like version 2
num = int(input("Enter a positive number: "))
choice = input("Do you want to sum even or odd numbers: ")
total = 0
counter = 0
print("Summing...", end=" ")
while counter <= num:
    if counter % 2 == 0 and choice == "even":
        total = counter + total
        print(counter, end=" ")
    elif counter % 2 == 1 and choice == "odd":
        total = counter + total
        print(counter, end=" ")
    # else:     # this means there is nothing to do

    counter = counter + 1
print("\nSum is", total)


# while loop sum with odd/even - version 2
num = int(input("Enter a positive number: "))
choice = input("Do you want to sum even or odd numbers: ")
if choice == "odd":  # set initial value
    counter = 1
else:
    counter = 0

total = 0
print("Summing...", end=" ")
while counter <= num:
    total = counter + total
    print(counter, end=" ")
    counter = counter + 2
print("\nSum is", total)



#While loop with break and continue
counter = 0
while True:
    counter += 1
    if counter > 10:
        break
    if counter == 5:
        continue
    print(counter)



#Purposefully creating infinite while loop
username = ""
while not username:
    username = input("Enter name: ")

#using randrange
import random

counter = 0
print("Now printing random numbers from 1-6")
while counter < 10:
	print(random.randrange(6) + 1, end=" ")
	counter+=1
print("\n"*3)


# for loop sum with odd/even - version 2
num = int(input("Enter a positive number: "))
choice = input("Do you want to sum even or odd numbers: ")
total = 0
if choice == "odd":  # set initial value
    start = 1
else:
    start = 0
print("Summing...", end=" ")
for i in range(start, num+1, 2):
    total = i + total
    print(i, end=" ")
print("\nSum is", total)

 */