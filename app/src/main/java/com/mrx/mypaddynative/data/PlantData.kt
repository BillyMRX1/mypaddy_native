package com.mrx.mypaddynative.data

import com.mrx.mypaddynative.R

object PlantData {
    private val diseasesId = arrayOf(
        0,
        1,
        2)

    private val diseasesNames = arrayOf(
        "Bacterial Leaf Blight",
        "Brown Spot",
        "Leaf Smut")

    private val diseasesDetails = arrayOf(
        "Penyakit daun padi jenis Bacterial leaf blight diakibatkan oleh bakteri yang menyerang pada bagian daun, serangan dimulai pada tepi daun. Daun yang terserang akan mengering berwarna hijau kelabu, helaian daun melengkung diikuti dengan melipatnya helaian daun, sepanjang ibu tulang daun berwarna kuning.",
        "Penyakit daun padi jenis Brown spot mempunyai ciri bercak pada daun yang khas berbentuk oval, berukuran variatif, bentuk dan gejala seragam dan seringkali tersebar diseluruh permukaan daun. Bercak berwarna coklat dilingkari dengan warna abu bagian tengah becak bulat berwarna putih. Gejala yang masih muda berupa binik-bintik coklat atau coklat keabuan. Pada varietas peka bercak akan lebih lebar berukuran mencapai 1 cm atau lebih. Jika bercak memenuhi permukaan daun maka akan berakibat daun menjadi layu.",
        "Daun maka akan berakibat daun menjadi layu patogen yang mengakibatkan munculnya bercak-bercak yang kecil, berbentuk garis pendek, lingkaran atau elips dengan ukuran panjang 0.5 – 5 mm dan lebar 0.5 – 1.5 mm. Apabila serangannya berat maka daun akan menguning dan menggulung.")

    private val diseasesSolution = arrayOf(
        arrayListOf("1. Menanam varietas tahan. Untuk daerah endemis varietas Code dan Angke",
            "2. Bibit padi yang ditanam tidak dipotong pada bagian ujungnya",
            "3. Jarak tanam jangan terlalu rapat, disarankan dengan cara tanam jejer legowo",
            "4. Pengairan berselang (intermiten), hindari penggenangan yang terus-menerus",
            "5. Pemupukan berimbang, jangan terlalu banyak pupuk N",
            "6. Jika intensitas penyakit melebihi 20%, semprot dengan bakterisida"
        ),
        arrayListOf("1. Jarak tanam yang tidak terlalu rapat terutama saat musim hujan",
            "2. Jika perlu gunakan cara tanam sistem legowo",
            "3. Jangan gunakan urea yang berlebih dan imbangi dengan unsur k",
            "4. Aplikasi fungisida pada daun tanaman padi, contoh: antracol, dithane, dan fungisida kontak lain sebagai pencegahnya. Jika sudah terserang gunakan fungisida sistemik seperti score, anvil, folicur, Nativo, opus, indar dll",
            "5. Penanaman varietas tahan, seperti Ciherang dan Membrano.",
            "6. Pemupukan berimbang yang lengkap, yaitu 250 kg urea, 100 kg SP36, dan 100 kg KCl per ha.",
            "7. Penyemprotan fungisida dengan bahan aktif difenoconazol, azoxistrobin, belerang, difenokonazol, tebukonazol, karbendazim, metil tiofanat, atau klorotalonil."
        ),
        arrayListOf("1. Jika perlu gunakan cara tanam sistem legowo",
            "2. Pemupukan berimbang, jangan terlalu banyak pupuk N",
            "3. Jarak tanam jangan terlalu rapat, disarankan dengan cara tanam jejer legowo",
            "4. Penyemprotan fungisida dengan bahan aktif difenoconazol, azoxistrobin, belerang, difenokonazol, tebukonazol, karbendazim, metil tiofanat, atau klorotalonil."
        ))

    private val plantImages = intArrayOf(
        R.drawable.blight,
        R.drawable.brown_spot,
        R.drawable.smut)

    val listData: ArrayList<Plant>
        get() {
            val list = arrayListOf<Plant>()
            for (position in diseasesId.indices) {
                val plant = Plant()
                plant.name = diseasesNames[position]
                plant.detail = diseasesDetails[position]
                plant.solution = diseasesSolution[position]
                plant.image = plantImages[position]
                list.add(plant)
            }
            return list
        }
}