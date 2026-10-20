// ******************************************************
// Name: Mobina Shafiani
// CS-210 Project One - Chada Tech Clocks
// Description: Displays 12-hour and 24-hour clocks,
//              allows user to add hour/minute/second,
//              follows flowchart and functional requirements.
// ******************************************************

#include <iostream>
#include <iomanip>
using namespace std;

// ---------------- Function Prototypes ----------------
void displayMenu();
void displayClocks(int hour, int minute, int second);
void addHour(int& hour);
void addMinute(int& minute, int& hour);
void addSecond(int& second, int& minute, int& hour);
string getAMPM(int hour);
int convertTo12Hour(int hour);

// ---------------- Main Program ----------------
int main() {

    int hour, minute, second;

    // Get initial time from user
    cout << "Enter initial hour (0-23): ";
    cin >> hour;
    cout << "Enter initial minute (0-59): ";
    cin >> minute;
    cout << "Enter initial second (0-59): ";
    cin >> second;

    int choice = 0;

    // LOOP until user chooses Exit
    while (choice != 4) {

        displayMenu();
        cin >> choice;

        if (choice == 1) {
            addHour(hour);
            displayClocks(hour, minute, second);
        }
        else if (choice == 2) {
            addMinute(minute, hour);
            displayClocks(hour, minute, second);
        }
        else if (choice == 3) {
            addSecond(second, minute, hour);
            displayClocks(hour, minute, second);
        }
        else if (choice == 4) {
            cout << "Exiting program..." << endl;
        }
        else {
            cout << "Invalid choice. Try again." << endl;
        }
    }

    return 0;
}

// ---------------- Display Menu ----------------
void displayMenu() {
    cout << "\n****************************\n";
    cout << "* 1 - Add One Hour         *\n";
    cout << "* 2 - Add One Minute       *\n";
    cout << "* 3 - Add One Second       *\n";
    cout << "* 4 - Exit Program         *\n";
    cout << "****************************\n";
    cout << "Enter your choice: ";
}

// ---------------- Display Clocks ----------------
void displayClocks(int hour, int minute, int second) {

    int hour12 = convertTo12Hour(hour);
    string ampm = getAMPM(hour);

    cout << "\n****************************\n";
    cout << "*     12-Hour Clock        *\n";
    cout << "*     " << setw(2) << setfill('0') << hour12 << ":"
        << setw(2) << minute << ":"
        << setw(2) << second << " " << ampm << "         *\n";
    cout << "****************************\n";

    cout << "****************************\n";
    cout << "*     24-Hour Clock        *\n";
    cout << "*     " << setw(2) << hour << ":"
        << setw(2) << minute << ":"
        << setw(2) << second << "             *\n";
    cout << "****************************\n\n";
}

// ---------------- Add One Hour ----------------
void addHour(int& hour) {
    hour++;
    if (hour == 24) {
        hour = 0;
    }
}

// ---------------- Add One Minute ----------------
void addMinute(int& minute, int& hour) {
    minute++;
    if (minute == 60) {
        minute = 0;
        addHour(hour);
    }
}

// ---------------- Add One Second ----------------
void addSecond(int& second, int& minute, int& hour) {
    second++;
    if (second == 60) {
        second = 0;
        addMinute(minute, hour);
    }
}

// ---------------- Convert to 12-Hour Format ----------------
int convertTo12Hour(int hour) {
    if (hour == 0) return 12;
    else if (hour > 12) return hour - 12;
    else return hour;
}

// ---------------- AM/PM ----------------
string getAMPM(int hour) {
    if (hour < 12) return "AM";
    else return "PM";
}

