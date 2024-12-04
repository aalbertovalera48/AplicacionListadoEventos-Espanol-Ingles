# Gestor-de-Eventos
Hecho por: Alberto Valera

Gestor de Eventos es una aplicación Android para gestionar eventos. Los usuarios pueden agregar, ver y guardar eventos con detalles como nombre, descripción, dirección, precio, fecha, aforo y una imagen opcional.

## Clases y Métodos

### MainActivity

`MainActivity` es el punto de entrada principal de la aplicación. Muestra una lista de eventos y proporciona un botón para agregar nuevos eventos.

- `onCreate(savedInstanceState: Bundle?)`: Inicializa la actividad, configura el RecyclerView y el FloatingActionButton.
- `onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)`: Maneja el resultado de `FormActivity` y actualiza la lista de eventos.

### FormActivity

`FormActivity` permite a los usuarios ingresar detalles del evento y seleccionar una imagen para el evento.

- `onCreate(savedInstanceState: Bundle?)`: Inicializa la actividad, configura los elementos de la interfaz de usuario y sus listeners.
- `onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)`: Maneja el resultado del selector de imágenes y establece la imagen seleccionada.
- `btnSave.setOnClickListener { ... }`: Recoge los detalles del evento y los devuelve a `MainActivity`.
- `btnSelectImage.setOnClickListener { ... }`: Abre el selector de imágenes para seleccionar una imagen.

### Evento

`Evento` es una clase de datos que representa un evento. Implementa `Parcelable` para permitir pasar objetos de evento entre actividades.

- `constructor(parcel: Parcel)`: Inicializa un objeto `Evento` desde un `Parcel`.
- `writeToParcel(parcel: Parcel, flags: Int)`: Escribe el objeto `Evento` en un `Parcel`.
- `describeContents()`: Describe el contenido del objeto `Parcelable`.

### EventAdapter

`EventAdapter` es un adaptador de RecyclerView para mostrar una lista de eventos.

- `onCreateViewHolder(parent: ViewGroup, viewType: Int)`: Infla el diseño del ítem y crea un ViewHolder.
- `onBindViewHolder(holder: EventViewHolder, position: Int)`: Vincula los datos del evento al ViewHolder.
- `getItemCount()`: Devuelve el número total de eventos.

### EventViewHolder

`EventViewHolder` es una clase ViewHolder para `EventAdapter`.

- `bind(event: Evento)`: Vincula los datos del evento a los elementos de la interfaz de usuario en la vista del ítem.

## Recursos

### Layouts

- `activity_main.xml`: Diseño para `MainActivity`, que contiene un RecyclerView y un FloatingActionButton.
- `activity_form.xml`: Diseño para `FormActivity`, que contiene EditTexts para los detalles del evento y un ImageView para la imagen del evento.
- `item_form.xml`: Diseño para ítems individuales de eventos en el RecyclerView.

### Drawables

- `ic_placeholder.jpg`: Imagen predeterminada utilizada cuando no se selecciona una imagen para un evento.
