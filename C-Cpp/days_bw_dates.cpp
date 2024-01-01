#include<iostream>

using namespace std;

int dd1, mm1, yy1;
int dd2, mm2, yy2;
bool incEndDate;
void check_incEndDate();
int getDayCount();
bool checkLeapYear(int year);
int getMonthDays(int month, bool leapOrNot);

int main() {
    cout<<"Welcome to Days Calculator !!!"<<endl;

    cout<<"Enter 1st date,  month,  year : ";
    cin>>dd1>>mm1>>yy1;
    cout<<"Enter 2nd date,  month,  year : ";
    cin>>dd2>>mm2>>yy2;

    check_incEndDate();

    int totalDayCount = getDayCount();
    cout<<"\nTotal days are - "<<totalDayCount<<endl;
    cout<<totalDayCount / 365<<" years "<<(totalDayCount % 365) / 30<<" months "<<(totalDayCount % 365) % 30<<" days"<<endl;
    cout<<totalDayCount / 30<<" months "<<totalDayCount % 30<<" days"<<endl;
    cout<<totalDayCount / 7<< " weeks "<<totalDayCount % 7<<" days"<<endl;
    cout<<totalDayCount * 24<<" hours - "<<totalDayCount * 24 * 60<<" minutes - "<<totalDayCount * 24 * 60 * 60<<" seconds"<<endl;

    return 0;
}

void check_incEndDate() {
    char userResp;
    cout<<"Do you want to include end date in calculation [y/n] : ";
    cin>>userResp;
    switch(userResp) {
        case 'y' : incEndDate = true;
            break;
        case 'n' : incEndDate = false;
            break;
        default : cout<<"Please enter a valid input !!!"<<endl;
            check_incEndDate();
    }
}

int getDayCount() {
    int daysCount = 0;
    // The 1st loop starts from first year and goes till last year
    for(int i = yy1; i <= yy2; i++) {
        bool leapOrNot = checkLeapYear(i);
        /** if start date start in between the year then
            loop starts from that particular month
            otherwise loop starts from January (01) **/
        int j;
        // (i == yy1) ? j = mm1 : j = 1;
        if(i == yy1) {
            j = mm1;
        } else {
            j = 1;
        }

        // The 2nd loop starts from first month and goes till last month
        for(j; j <= 12; j++) {
            /** count the number of days in first month ONLY
                AND skip to the next month **/
            if(i == yy1 && j == mm1) {
                daysCount += (getMonthDays(mm1, leapOrNot) - (dd1-1));
                continue;
            }
            /** count the number of days in last month ONLY
                AND break the loop in the last month **/
            if(i == yy2 && j == mm2) {
                if(incEndDate) {
                    daysCount += dd2;
                } else {
                    daysCount += (dd2-1);
                }
                break;
            }
            // count the number of days in rest of the month
            daysCount += getMonthDays(j, leapOrNot);
            // cout<<j<<" - "<<getMonthDays(j, leapOrNot)<<endl;
        }
    }
    return daysCount;
}

bool checkLeapYear(int year) {
    /** if the year is in multiple of 100 then
        will check for divisibilty by 100 and 400
        otherwise check for divisiblity by 4
        AND return the boolean value **/
    if(year % 100 == 0) {
        if(year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    } else {
        if(year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

int getMonthDays(int month, bool leapOrNot) {
    // returns the number of days in each month
    if(month == 1 || month == 3 || month == 5 || month == 7 || 
        month == 8 || month == 10 || month == 12) {
        return 31;
    } else if(month == 4 || month == 6 || month == 9 || month == 11) {
        return 30;
    } else {
    // check for leap year and return 28-29 days accordingly
        if(leapOrNot) {
            return 29;
        } else {
            return 28;
        }
    }
}