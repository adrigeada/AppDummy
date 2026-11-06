package edu.geadaadrian.appdummy.navegacion

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import edu.geadaadrian.appdummy.screens.bienvenida.PantallaBienvenida
import edu.geadaadrian.appdummy.screens.detalle.PantallaDetalle
import edu.geadaadrian.appdummy.screens.favoritos.PantallaFavoritos
import edu.geadaadrian.appdummy.screens.listado.PantallaListado
import edu.geadaadrian.appdummy.screens.permisos.PantallaGestionPermisos

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
             AppDummyBottomBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Inicio,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<Inicio> {
                PantallaBienvenida(
                    onEntrar = {
                        navController.navigate(Listado) {
                            popUpTo(Inicio) { inclusive = true }
                        }
                    }
                )
            }

            composable<Listado> {
                PantallaListado(    // <- Composable de la pantalla listado.
                    onNavegaADetalle = { id ->
                        navController.navigate(Detalle(id = id))    // <- Ruta de Navegación a la pantalla detalle con el id del libro.
                    },
                    onNavegaAPermisos = {
                        navController.navigate(Permisos)    // <- Ruta de Navegación a la pantalla de permisos.
                    }
                )
            }

            composable<Detalle> {
                PantallaDetalle(
                    onVolver = { navController.navigateUp() }
                )
            }

            composable<Favoritos> {
                PantallaFavoritos(
                    onNavegaADetalle = { id ->
                        navController.navigate(Detalle(id = id))
                    },
                    onNavegaAPermisos = {
                        navController.navigate(Permisos)
                    }

                )
            }

            composable<Permisos> {
                PantallaGestionPermisos(
                    onVolver = { navController.navigateUp() }

                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview(){
    AppNavigation()
}