#include<iostream>

using namespace std;

int minimumCost()
{

    int purple_cost,green_cost,participants;

    cin>>purple_cost;

    cin>>green_cost;

    cin>>participants;

    int status1 , status2;

    int totalCost1 = 0, totalCost2 = 0;

    while(participants--)

    {
        cin>>status1;

        cin>>status2;

        totalCost1 += green_cost*status1 + purple_cost*status2;

        totalCost2 += purple_cost*status1 + green_cost*status2;
    }

    return totalCost1 < totalCost2 ? totalCost1 : totalCost2;
}

int main()
{
    int testcases;

    cin>>testcases;

    while(testcases--)

    {
        cout<<minimumCost()<<endl;
    }

    return 0;

}


