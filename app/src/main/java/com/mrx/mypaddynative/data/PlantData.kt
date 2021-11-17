package com.mrx.mypaddynative.data

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
        "aun maka akan berakibat daun menjadi layu patogen yang mengakibatkan munculnya bercak-bercak yang kecil, berbentuk garis pendek, lingkaran atau elips dengan ukuran panjang 0.5 – 5 mm dan lebar 0.5 – 1.5 mm. Apabila serangannya berat maka daun akan menguning dan menggulung.")

    val listData: ArrayList<Plant>
        get() {
            val list = arrayListOf<Plant>()
            for (position in diseasesId.indices) {
                val plant = Plant()
                plant.name = diseasesNames[position]
                plant.detail = diseasesDetails[position]
                list.add(plant)
            }
            return list
        }
}