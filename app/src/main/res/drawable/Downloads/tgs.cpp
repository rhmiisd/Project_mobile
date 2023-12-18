#include<stdio.h>
#include<stdlib.h>
#include<windows.h>

struct mahasiswa
{
	char nama[50], status[50], ttl[20], darah[20];
	int no, nilai;
	struct mahasiswa *next,*prev;
}*beg, *last;

int input()
{
	struct mahasiswa *simpan,*pertama;
	int i=0;
	char pilihan[2];
	
	while(1){
		system("cls");
		pertama=(struct mahasiswa*)malloc(sizeof(struct mahasiswa));
		fflush(stdin);
		printf("|========|MASUKAN DATA PESERTA DAYA TAHAN|========|\n");
		printf("|=================================================|\n\n");
		printf("Nama peserta lomba\t\t: ");
		gets(pertama->nama);
		fflush(stdin);
		
		printf("No Peserta\t\t\t: ");
		scanf("%d", &pertama->no);
		fflush(stdin);
		
		printf("Status\t\t\t\t: "); 
		gets(pertama->status);
		
		printf("Tanggal lahir\t\t\t: "); 
		gets(pertama->ttl);
		
		printf("Golongan Darah\t\t\t: ");
		gets(pertama->darah);
		
		if(i==0)
		{
			pertama->next=NULL;
			pertama->prev=NULL;
			beg=pertama;
			simpan=beg;
			last=pertama;
		}
		else
		{
			simpan->next=pertama;
			pertama->next=NULL;
			pertama->prev=simpan;
			last=pertama;
			simpan=pertama;
		}
		system("cls");
		printf("\nApakah ingin memasukkan data lagi? (y/t) "); 
		scanf("%s",&pilihan);
		if((strcmp(pilihan, "Y")==0)||(strcmp(pilihan,"y")==0)){
			i++;
			continue;
		}
		else{
			break;
		}
	}
}



int hapus_data(){
	struct mahasiswa *hapus;
	char cari[30];
	if(beg==NULL){
		printf("Belum Ada Data. Silahkan Masukkan Data!");
		}
	else{
		printf("Masukkan nama peserta Yang Akan Dihapus : "); 
		gets(cari);
		if(strcmp(beg->nama,cari)==0){
			printf("DATA BERHASIL DIHAPUS");
			hapus= beg->next;
            free(beg);
            beg = hapus;
        }
	}
}


int tampil(){
	system("cls");
	struct mahasiswa *tampil;
	tampil=beg;
	printf("==========TAMPILAN DATA PESERTA==========\n");
	while(tampil!=NULL){
		printf("\n|%s\t\t|", tampil->nama);
		printf("|%d\t|", tampil->no);
		printf("|%s\t\t|", tampil->status);
		printf("|%s\t|", tampil->ttl);
		printf("|%s\t|\n", tampil->darah);
		
		tampil=tampil->next;
	}
	return 0;
}

int hasil(){
	system("cls");
	struct mahasiswa *hasil;
	hasil=beg;
	printf("==========TAMPILAN DATA PESERTA==========\n");
	while(hasil!=NULL){
		printf("\n|%s\t\t|", hasil->nama);
		printf("|%d\t|", hasil->no);
		printf("|%s\t\t|", hasil->status);
		printf("|%s\t|", hasil->ttl);
		printf("|%s\t|\n", hasil->darah);
		printf("|%d\t|\n", hasil->nilai);
		
		hasil=hasil->next;
	}
	return 0;
}

struct peserta {
    int no;
    char nama[10];
    int jam;
    int mnt;
    int dtk;
    int jml;
};



int nilai()
{
    int a,x,y,z,i;
    char nama[50];
    
    printf("Masukkan Jumlah Peserta : ");
    scanf("%d",&x);
    
    struct peserta pes[x], swap;
    
    for (i=0; i<x;i++) {
        printf("No : ");
        scanf("%d",&pes[i].no);
        fflush(stdin);
        printf("Nama : ");
        gets(nama);
        fflush(stdin);
        printf("JAM : ");
        scanf("%d",&pes[i].jam);
        printf("MENIT : ");
        scanf("%d",&pes[i].mnt);
        printf("DETIK : ");
        scanf("%d",&pes[i].dtk);
        printf("-----------------------------\n");
        pes[i].jml = (pes[i].jam*1)+(pes[i].mnt*1);
    };
    for(z=0; z<x-1; z++) {
        for(y=0; y<x-1; y++) {
            if(pes[y].jml < pes[y+1].jml) {
                swap = pes[y];
                pes[y] = pes[y+1];
                pes[y+1] = swap;
            }
        }
    }
    
    for(a=0; a<x; a++) {
      printf("%d: %d + %d, Hasil Total : %d\n",pes[a].no,pes[a].jam,pes[a].mnt,pes[a].jml);
       
    }
    printf("URUTAN BERDASARKAN RANKING TERATAS\n");
}


int main(){
	system("cls");
	int pilihan;
	char lanjut[2];
	
	menu:
	system("cls");

	printf("\t||========================================||\n");
	printf("\t||SELAMAT DATANG DIPROGRAM DATA DAYA TAHAN||\n");
	printf("\t||========================================||\n\n\n");
	printf("Silahkan pilih di bawah ini :\n");
	printf("\n1. Input Data\n2. Hapus Data\n3. Tampilkan Data\n4. Masukkan Nilai Dan Lihat Hasil\n5. Keluar\n\n");
	printf("\n==========================================\n");
	scanf("%d",&pilihan); fflush(stdin);
	switch(pilihan){
		case 1:
			input();
			break;
		case 2:
			goto hapus;
			break;
		case 3:
			goto tampil;
			break;
		case 4:
			goto nilai;
			break;
		case 5:
			goto exit;
			break;
	}
	goto menu;
	hapus:
	tampil();
	printf("Apakah Anda Ingin Menghapus Data peserta? (y/t)");
	scanf("%s",&lanjut); fflush(stdin);
	if((strcmp(lanjut,"Y")==0)||(strcmp(lanjut,"y")==0)){
		hapus_data();
		goto tampil;
	}
	else{
		goto menu;
	}
	
	tampil:
	tampil();
	printf("Apakah Anda Ingin Mengolah Data? (y/t) "); 
	scanf("%s",&lanjut);
	if((strcmp(lanjut,"Y")==0)||(strcmp(lanjut,"y")==0)){
		goto menu;
	}
	else{
		goto exit;
	}
	
	hasil:
	hasil();
	printf("Apakah Anda Ingin Mengolah Data Lagi? (y/t) ");
	scanf("%s",&lanjut);
	if((strcmp(lanjut,"Y")==0)||(strcmp(lanjut,"y")==0))
	{
		goto menu;
	}else{
		goto exit;
	}
	
	nilai:
	nilai();
	printf("Apakah Anda Ingin Mengolah Data Lagi? (y/t) ");
	scanf("%s",&lanjut);
	if((strcmp(lanjut,"Y")==0)||(strcmp(lanjut,"y")==0))
	{
		goto menu;
	}
	else{
		goto menu;
	}
	

	exit:
		printf("THANKS FOR USE THIS PROGRAM");
		getchar();
		

		return 0;
}
