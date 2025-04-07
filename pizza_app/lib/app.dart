import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:user_repository/user_repository.dart';

import 'app_view.dart';
import 'blocs/authentification_bloc/authentification_bloc.dart';

class MyApp extends StatelessWidget {
  final UserRepository userRespository;

  const MyApp(this.userRespository, {super.key});

  @override
  Widget build(BuildContext context) {
    return RepositoryProvider<AuthentificationBloc>(
      create:
          (context) => AuthentificationBloc(userRespository: userRespository),
      child: MyAppView(),
    );
  }
}
