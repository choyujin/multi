/* ��Ƽ�̵����а� 1110811 ������
   ���൹ ���� ���� recursive */ 

#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#define max(a,b)(((a)>(b))?(a):(b))
#define Random(max) rand() % ((max))
#define MAXCOL 3 // 3*n table�̹Ƿ� ���� 3���� ����

typedef enum Pattern{
	Pattern_one,
	Pattern_two,
	Pattern_three,
	Pattern_four
}Pattern;

int pebble(int i, int pattern, int** table);	// i���� ���� p�� ���� ���� �ְ����� ���ϱ�
int w(int row, int pattern, int** table);
bool Is_Compatible(int origin_pattern, int Comparsion_pattern);
int** Malloc(int col, int row);				// 2���� �迭 ���� �Ҵ�
int** Free(int col, int row, int** arr);		// 2���� �迭 �޸� ����

int main()
{
	int** table; // 2���� ���̺�
	int i, j, MAXROW, input_pattern;
	size_t result = 0; // ����� �� ���� 
	int MAX = 0;

	printf("���൹ Table�� �� ũ�� : ");
	scanf_s("%d", &MAXROW); // ���� 3���� �����̹Ƿ� ���� �Է¹޴´�. 

	if(MAXROW<=0) {
		printf("�߸��� �Է��Դϴ�.\n");
		exit(1);
	}

	table = Malloc(MAXCOL, MAXROW); // 2���� �迭 ��������
	
	//Randomize(); 
	for(i=0; i<MAXCOL; i++) { // 2���� �迭 �� ��������
		for(j=0; j<MAXROW; j++)
			table[i][j] = Random(50);
	}

	for(i=0; i<MAXCOL; i++) { // 2�����迭 ���
		for(j=0; j<MAXROW; j++) 
			printf(" %3d ", table[i][j]);
		
		fputc('\n', stdout);
	}
	
	LARGE_INTEGER liCounter1, liCounter2, liFrequency; 
    QueryPerformanceFrequency(&liFrequency); // ���ļ�(1�ʴ� �����Ǵ� ī��Ʈ��)�� ���Ѵ�. 
    QueryPerformanceCounter(&liCounter1); // �ڵ� ���� �� ī��Ʈ ����

	for(i=0; i <= Pattern_four; i++){ // i���� ���� p�� ���� ���� �ְ����� ���ϱ�
		MAX = pebble(MAXROW-1, i, table);
		result = ((int)result < MAX)? MAX : result;
	}
	
	QueryPerformanceCounter(&liCounter2); // �ڵ� ���� �� ī��Ʈ ����

	printf("result = %d\n", result);
	printf("recursive_���� �ð� = %f ��\n", (double)(liCounter2.QuadPart - liCounter1.QuadPart) / (double)liFrequency.QuadPart); 


	table = Free(MAXCOL, MAXROW, table); // �޸� ��������

	return 0;
}

// i���� ���� p�� ���� ���� �ְ����� ���ϱ�
// w[i,p] : i���� ���� p(pattern)�� ���� �� i���� ���� ���� ���� ������
int pebble(int i,  int pattern, int** table)
{
	int tmp = 0; // ���� �ܰ��� ���� �� �ӽ� ����
	int max = 0; // �̹� �ܰ��� ���� ��
	int q; // � �������� ����
	
	if(i==0) { // 1���� ���, �� ���� �ִ밪�� return
		return w(i, pattern, table);
	} else {
		max = -999; // ���� ���Ѵ� - �ſ� ���� ��

		for(q=Pattern_one; q<=Pattern_four; q++) { // 4���� ����
			if (Is_Compatible(pattern,q)) { // �縳�ϸ� ����
				tmp = pebble(i-1, q, table); // ���� �ϳ� �������� �� ���� �� 
				if(tmp > max)  // �縳�ϴ� ���� �� ���� ū �� ����
					max = tmp;
			}
		}
	}
	return (max + w(i, pattern, table)); // ���� �ܰ������ �ִ밪�� �̹� ���� �ִ밪 ���Ѵ�.
}

// w[i,p] : i���� ���� p�� ���� �� i���� ���� ���� ���� ������.
int w(int i,  int pattern, int** table )
{
	int result=0;
	
	switch(pattern){
		case Pattern_one:
			result = table[Pattern_one][i];
			break;

		case Pattern_two:
			result = table[Pattern_two][i];
			break;

		case Pattern_three:
			result = table[Pattern_three][i];
			break;

		case Pattern_four:
			result += table[Pattern_one][i];
			result += table[Pattern_three][i];
			break;
	}
	return result;
}

bool Is_Compatible(int origin_pattern, int Comparsion_pattern)
{
	bool result = false; // �縳�� �� �������� �ʱ�ȭ. true�� ��, �縳�� �� ���� 

	switch(origin_pattern){ // ���� ���ϰ� �縳�� �� �ִ��� Ȯ��
		case Pattern_one: // ���� 1�� ���� 2,3�� �縳�� �� ����
			if( Comparsion_pattern == Pattern_two || Comparsion_pattern == Pattern_three) 
				result = true;
			break;

		case Pattern_two: // ���� 2�� ���� 1,3,4�� �縳�� �� ����
			if( Comparsion_pattern == Pattern_one || Comparsion_pattern == Pattern_three || Comparsion_pattern == Pattern_four ) 
				result = true;
			break;

		case Pattern_three: // ���� 3�� ���� 1,2�� �縳�� �� ����
			if( Comparsion_pattern == Pattern_one || Comparsion_pattern == Pattern_two) 
				result = true;
			break;

		case Pattern_four: // ���� 4�� ���� 2�� �縳�� �� ����
			if( Comparsion_pattern == Pattern_two ) 
				result = true;
			break;
	}
	return result;
}

int** Malloc(int col, int row) // ���� �Ҵ�
{
	int **arr;
    int i;
 
    arr = (int**)malloc(col * sizeof(int*));
 
    for(i=0; i<col; i++)
		arr[i] = (int*)malloc(row * sizeof(int));
        
    return arr;
} 

int** Free(int col, int row, int** arr) // ���� �Ҵ� ����
{
	int i;
 
    for(i=0; i<col; i++)
		free(arr[i]);
        
    free(arr);

    return arr;
}

int _tmain(int argc, _TCHAR* argv[])
{
	return 0;
}


