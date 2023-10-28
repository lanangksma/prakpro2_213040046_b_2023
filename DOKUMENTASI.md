# DOKUMENTASI TUGAS LATIHAN 7 - 213040046

- # [TABLE OF CONTENT](#dokumentasi-tugas-latihan-7---213040046)
    - [Kelas BiodataApp](#kelas-biodataapp)
    - [Kelas Biodata](#kelas-biodata)
    - [Kelas ActionManagerUtil](#kelas-actionmanagerutil)
    - [Kelas InputDialogManagerUtil](#kelas-inputdialogmanagerutil)
    - [Kelas AddComponentsManagerUtil](#kelas-addcomponentsmanagerutil)
    - [Kelas BiodataView](#kelas-biodataview)
    - [Kelas TableManagerUtil](#kelas-tablemanagerutil)
    - [Kelas ComponentManagerUtil](#kelas-componentmanagerutil)


## Kelas BiodataApp

mendefinisikan kelas `BiodataApp` dengan Method `main()`. Method `main()` ini adalah titik masuk aplikasi.

- `javax.swing.SwingUtilities.invokeLater(new Runnable() {...})`: Baris kode ini digunakan untuk memastikan bahwa GUI dibuat di Event Dispatch Thread (EDT). Ini adalah praktik yang baik dalam pemrograman Swing karena Swing tidak thread-safe, dan ini membantu mencegah potensi masalah threading.


- `BiodataView b = new BiodataView(); b.setVisible(true);`: Baris kode ini membuat instance baru dari kelas BiodataView dan membuatnya terlihat. Kelas `BiodataView` adalah subkelas dari `JFrame` dan mendefinisikan tampilan utama aplikasi.

## Kelas Biodata

Mendefinisikan sebuah kelas Biodata dalam paket entity. Kelas ini memiliki empat atribut:` nama, nomorHP, jenisKelamin, dan alamat`.

- nama: Atribut ini digunakan untuk menyimpan nama dari individu.
- nomorHP: Atribut ini digunakan untuk menyimpan nomor telepon dari individu.
- jenisKelamin: Atribut ini digunakan untuk menyimpan jenis kelamin dari individu.
- alamat: Atribut ini digunakan untuk menyimpan alamat dari individu.

Konstruktor kelas ini menerima empat parameter yang sesuai dengan empat atribut di atas. Setiap parameter diteruskan ke atribut yang sesuai.

Method `toArrayList()` mengubah empat atribut ini menjadi sebuah ArrayList. Ini dilakukan dengan membuat ArrayList baru dari Array yang dibuat menggunakan Method `Arrays.asList()`. Array ini berisi empat atribut kelas.

## Kelas ActionManagerUtil

Mendefinisikan beberapa Method dalam kelas `ActionManagerUtil`:

- `createSaveAction()`: Method ini membuat dan mengembalikan ActionListener yang dapat digunakan untuk menyimpan data ke tabel. Method ini memvalidasi input pengguna dan menampilkan dialog konfirmasi sebelum menyimpan data. Jika pengguna memilih untuk menyimpan data, data tersebut akan ditambahkan ke tabel dan pesan konfirmasi akan ditampilkan.


- `createEditAction()`: Method ini membuat dan mengembalikan ActionListener yang dapat digunakan untuk mengedit data di tabel. Method ini meminta ID baris yang ingin diedit oleh pengguna, memvalidasi ID tersebut, dan menampilkan dialog edit dengan nilai yang ada saat ini. Jika pengguna memilih untuk mengedit data, data tersebut akan diperbarui di tabel.


- `createSaveFileAction()`: Method ini membuat dan mengembalikan ActionListener yang dapat digunakan untuk menyimpan data tabel ke file. Method ini menampilkan dialog konfirmasi sebelum menyimpan data ke file. Jika pengguna memilih untuk menyimpan data, data tersebut akan disimpan ke file dan pesan konfirmasi akan ditampilkan.


- `createClearAction()`: Method ini membuat dan mengembalikan ActionListener yang dapat digunakan untuk menghapus semua data dari tabel. Method ini menampilkan dialog konfirmasi sebelum menghapus semua data. Jika pengguna memilih untuk menghapus data, semua data akan dihapus dari tabel dan pesan konfirmasi akan ditampilkan.

## Kelas InputDialogManagerUtil

mendefinisikan kelas InputDialogManagerUtil dengan satu Method `showEditDialog(ArrayList<String> existingValue)`:

`Method showEditDialog(ArrayList<String> existingValue)` digunakan untuk menampilkan dialog edit dengan nilai yang ada saat ini. Method ini menerima `ArrayList` yang berisi nilai-nilai yang ada dan mengembalikan `ArrayList` baru yang berisi nilai-nilai baru setelah pengguna selesai mengedit.

Dalam Method ini, beberapa `JTextField`, `JRadioButton`, dan `JTextArea` dibuat dan diisi dengan nilai-nilai yang ada. Kemudian, sebuah dialog konfirmasi ditampilkan dengan komponen-komponen ini. Jika pengguna memilih untuk mengedit data, nilai-nilai baru dikumpulkan dari komponen-komponen ini dan dikembalikan. Jika pengguna membatalkan dialog, Method ini mengembalikan `null`.

## Kelas AddComponentsManagerUtil

Mendefinisikan sebuah kelas `AddComponentsManagerUtil` dalam paket utils.components. Kelas ini memiliki satu atribut: frame.

frame: Atribut ini digunakan untuk menyimpan objek JFrame yang akan ditambahkan komponen.
Konstruktor kelas ini menerima satu parameter yaitu objek JFrame. Parameter ini diteruskan ke atribut frame.

Method add(JComponent... components) adalah Method yang digunakan untuk menambahkan komponen ke dalam frame. Method ini menerima parameter berupa array dari JComponent (dapat juga disebut sebagai varargs). Dalam Method ini, setiap komponen dalam array tersebut ditambahkan ke dalam frame menggunakan Method add() dari objek JFrame.

## Kelas BiodataView

Mendefinisikan kelas `BiodataView` yang merupakan subkelas dari JFrame. Kelas ini digunakan untuk membuat tampilan form biodata.

`initializeComponents()`: Method ini digunakan untuk menginisialisasi komponen-komponen yang akan ditampilkan di form. Ini mencakup label, field teks, radio button, area teks, dan tombol. Semua komponen ini dibuat menggunakan Method dari kelas `ComponentManagerUtil`.

`addActionListeners()`: Method ini digunakan untuk menambahkan ActionListener ke tombol. Ini dilakukan dengan membuat instance dari kelas `ActionManagerUtil` dan memanggil Method `createSaveAction(), createEditAction(), createClearAction(), dan createSaveFileAction()`.

`addComponentsToFrame()`: Method ini digunakan untuk menambahkan semua komponen ke frame. Ini dilakukan dengan membuat instance dari kelas `AddComponentsManagerUtil` dan memanggil Method `add()`.

## Kelas TableManagerUtil

Mendefinisikan kelas `TableManagerUtil` yang merupakan subkelas dari `AbstractTableModel`. Kelas ini digunakan untuk mengelola data dalam tabel.

- `getRowCount()`: Method ini mengembalikan jumlah baris dalam tabel.


- `getColumnCount()`: Method ini mengembalikan jumlah kolom dalam tabel.


- `getValueAt(int rowIndex, int columnIndex)`: Method ini mengembalikan nilai pada baris dan kolom tertentu dalam tabel.


- `getColumnName(int columnIndex)`: Method ini mengembalikan nama kolom pada indeks tertentu.


- `isCellEditable(int rowIndex, int columnIndex)`: Method ini mengembalikan apakah sel pada baris dan kolom tertentu dapat diedit. Dalam kasus ini, semua sel diatur untuk tidak dapat diedit.


- `addRow(ArrayList<String> value)`: Method ini digunakan untuk menambahkan baris baru ke tabel. Baris baru ditambahkan ke akhir tabel dan ID otomatis ditetapkan berdasarkan jumlah baris saat ini.


- `editRow(int rowIndex, ArrayList<String> newValue)`: Method ini digunakan untuk mengedit baris yang ada dalam tabel. Jika indeks baris valid, baris tersebut akan diperbarui dengan nilai baru.


- `getData()`: Method ini mengembalikan semua data dalam tabel.


- `getRow(int rowIndex)`: Method ini mengembalikan baris pada indeks tertentu dalam tabel.


- `clearTable()`: Method ini digunakan untuk menghapus semua data dari tabel.

## Kelas ComponentManagerUtil

mendefinisikan sebuah kelas ComponentManagerUtil dalam paket utils.components. Kelas ini memiliki beberapa Method untuk membuat komponen Swing:

createLabel(String text, int x, int y): Method ini membuat objek JLabel dengan teks yang diberikan dan mengatur posisinya berdasarkan koordinat x dan y. Lebar dan tinggi label diatur menjadi 350 dan 10 secara default.

createTextField(int x, int y): Method ini membuat objek JTextField dan mengatur posisinya berdasarkan koordinat x dan y. Lebar dan tinggi field teks diatur menjadi 350 dan 30 secara default.

createRadioButton(String text, int x, int y): Method ini membuat objek JRadioButton dengan teks yang diberikan dan mengatur posisinya berdasarkan koordinat x dan y. Lebar dan tinggi radio button diatur menjadi 350 dan 30 secara default.

createTextArea(int x, int y): Method ini membuat objek JTextArea dan mengatur posisinya berdasarkan koordinat x dan y. Lebar dan tinggi area teks diatur menjadi 350 dan 100 secara default. Area teks juga diberi border hitam.

createButton(String text, int x, int y): Method ini membuat objek JButton dengan teks yang diberikan dan mengatur posisinya berdasarkan koordinat x dan y. Lebar dan tinggi button diatur menjadi 120 dan 40 secara default.
